package by.ibragimov.heap.domain;

import by.ibragimov.heap.utils.annotations.profiles.DefaultProfile;
import by.ibragimov.heap.utils.annotations.profiles.DevelopmentProfile;
import by.ibragimov.heap.utils.annotations.profiles.ProductionProfile;
import by.ibragimov.heap.utils.annotations.profiles.TestProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = DaoConfig.class)
@EnableJpaRepositories(basePackageClasses = DaoConfig.class)
public class DaoConfig {

    @Configuration
    @PropertySource({"classpath:dev.properties"})
    @DevelopmentProfile
    static class DevConfiguration {
    }

    @Configuration
    @PropertySource({"classpath:prod.properties"})
    @ProductionProfile
    static class ProductionConfiguration {
    }

    @Configuration
    @PropertySource({"classpath:test.properties"})
    @TestProfile
    @DefaultProfile
    static class TestConfiguration {
    }

    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

    @Bean
    @DefaultProfile
    @TestProfile
    public DataSource h2DataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setType(EmbeddedDatabaseType.H2).build();
    }

    @Bean
    @ProductionProfile
    @DevelopmentProfile
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(Boolean.valueOf(env.getProperty("hibernate.generate.ddl")));
        vendorAdapter.setShowSql(Boolean.valueOf(env.getProperty("hibernate.show_sql")));
        vendorAdapter.setDatabase(Database.valueOf(env.getProperty("database")));

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(DaoConfig.class.getPackage().getName());
        factory.setDataSource(dataSource);

        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        factory.setJpaProperties(jpaProperties);

        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public HibernateExceptionTranslator hibernateExceptionTranslator() {
        return new HibernateExceptionTranslator();
    }
}

package by.ibragimov.heap.web;

import by.ibragimov.heap.web.data.DefaultDataImporter;
import by.ibragimov.heap.domain.DaoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Enables support for @Controller-annotated classes.
 */
@EnableWebMvc
@Import(value = {DaoConfig.class})
@ComponentScan(basePackageClasses = WebMvcConfig.class)
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private FormattingConversionService mvcConversionService;

    @Autowired
    private DefaultDataImporter defaultDataImporter;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("/dist/assets/");
        registry.addResourceHandler("/*.html").addResourceLocations("/dist/");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Bean
    public DomainClassConverter domainClassConverter() {
        return new DomainClassConverter<>(mvcConversionService);
    }
}
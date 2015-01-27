package by.ibragimov.natrus.dao;

import by.ibragimov.natrus.dao.entities.BaseEntity;
import by.ibragimov.natrus.dao.entities.Bookmark;
import by.ibragimov.natrus.dao.entities.Tag;
import by.ibragimov.natrus.dao.entities.Users;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Ignore;
import org.junit.Test;

public class ExportDatabaseSchema {

    @Test
    @Ignore(value = "This is not test in fact. Just easy way to generate current SQL from model.")
    public void export() throws Exception {
        Configuration configuration = new Configuration();

        configuration
                .addAnnotatedClass(BaseEntity.class)
                .addAnnotatedClass(Bookmark.class)
                .addAnnotatedClass(Tag.class)
                .addAnnotatedClass(Users.class)
                .setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");

        SchemaExport schema = new SchemaExport(configuration);
        schema.setDelimiter(";");
        schema.setFormat(true);
        schema.setOutputFile("schema.sql");
        schema.create(true, false);
    }
}

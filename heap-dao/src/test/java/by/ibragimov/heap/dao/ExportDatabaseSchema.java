package by.ibragimov.heap.dao;

import by.ibragimov.heap.domain.bookmarks.Bookmark;
import by.ibragimov.heap.domain.bookmarks.Tag;
import by.ibragimov.heap.domain.common.BaseHeapUsersEntity;
import by.ibragimov.heap.domain.common.BaseEntity;
import by.ibragimov.heap.domain.common.HeapUser;
import by.ibragimov.heap.domain.todo.Task;
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
                .addAnnotatedClass(Task.class)
                .addAnnotatedClass(HeapUser.class)
                .addAnnotatedClass(BaseHeapUsersEntity.class)
                .setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");

        SchemaExport schema = new SchemaExport(configuration);
        schema.setDelimiter(";");
        schema.setFormat(true);
        schema.setOutputFile("schema.sql");
        schema.create(true, false);
    }
}

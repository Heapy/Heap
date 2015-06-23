package by.ibragimov.heap.domain.todo;

import by.ibragimov.heap.domain.common.BaseHeapUsersEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Task extends BaseHeapUsersEntity<Task> {

    private String title;

    public String getTitle() {
        return this.title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }
}

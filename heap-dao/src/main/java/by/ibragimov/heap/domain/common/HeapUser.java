package by.ibragimov.heap.domain.common;

import by.ibragimov.heap.domain.bookmarks.Bookmark;
import by.ibragimov.heap.domain.todo.Task;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class HeapUser extends BaseEntity<HeapUser> {

    private String email;

    private String password;

    private String secret;

    @OneToMany
    private List<Task> tasks;

    @OneToMany
    private List<Bookmark> bookmarks;

    public String getEmail() {
        return email;
    }

    public HeapUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public HeapUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSecret() {
        return secret;
    }

    public HeapUser setSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public HeapUser setTasks(List<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public HeapUser setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
        return this;
    }
}

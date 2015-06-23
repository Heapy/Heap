package by.ibragimov.heap.domain.bookmarks;

import by.ibragimov.heap.domain.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Tag extends BaseEntity<Tag> {

    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Bookmark> bookmarks;

    public String getName() {
        return this.name;
    }

    public Tag setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Bookmark> getBookmarks() {
        return this.bookmarks;
    }

    public Tag setBookmarks(Set<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
        return this;
    }
}

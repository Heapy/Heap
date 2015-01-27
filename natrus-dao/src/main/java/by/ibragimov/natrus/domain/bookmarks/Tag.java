package by.ibragimov.natrus.domain.bookmarks;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Tag extends BaseEntity<Tag> {

    private String name;

    @ManyToMany(mappedBy = "tags")
    private Set<Bookmark> bookmarks = new HashSet<>();

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

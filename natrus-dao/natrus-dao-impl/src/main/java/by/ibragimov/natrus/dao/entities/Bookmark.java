package by.ibragimov.natrus.dao.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Bookmark extends BaseEntity<Bookmark> {

    private String title;

    private String url;

    @ManyToMany(cascade = { CascadeType.ALL })
    private Set<Tag> tags = new HashSet<>();

    private String note;

    public String getTitle() {
        return this.title;
    }

    public Bookmark setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public Bookmark setUrl(String url) {
        this.url = url;
        return this;
    }

    public Set<Tag> getTags() {
        return this.tags;
    }

    public Bookmark setTags(Set<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public String getNote() {
        return this.note;
    }

    public Bookmark setNote(String note) {
        this.note = note;
        return this;
    }
}

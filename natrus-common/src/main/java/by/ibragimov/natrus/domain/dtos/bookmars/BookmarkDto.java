package by.ibragimov.natrus.domain.dtos.bookmars;

import by.ibragimov.natrus.domain.dtos.BaseDto;
import by.ibragimov.natrus.domain.markers.Identified;
import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents bookmarks in the system.
 */
public final class BookmarkDto implements Identified<Long>, BaseDto {

    private final Long id;

    private final String title;

    private final String url;

    private final Set<TagDto> tags;

    private final String note;

    private BookmarkDto(Builder builder) {
        id = builder.id;
        title = builder.title;
        url = builder.url;
        tags = ImmutableSet.copyOf(builder.tags);
        note = builder.note;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Set<TagDto> getTags() {
        return tags;
    }

    public String getNote() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookmarkDto that = (BookmarkDto) o;

        if (!id.equals(that.id)) return false;
        if (note != null ? !note.equals(that.note) : that.note != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        if (!title.equals(that.title)) return false;
        if (!url.equals(that.url)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + url.hashCode();
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookmarkDto{" + "id=" + id + ", title='" + title + '\'' + ", url='" + url + '\'' + ", tags=" + tags
                + ", note='" + note + '\'' + '}';
    }

    public static final class Builder {
        private Long id;
        private String title;
        private String url;
        private Set<TagDto> tags = new HashSet<>();
        private String note;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder tags(Set<TagDto> tags) {
            this.tags = tags;
            return this;
        }

        public Builder tag(TagDto tag) {
            this.tags.add(tag);
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public BookmarkDto build() {
            return new BookmarkDto(this);
        }
    }
}

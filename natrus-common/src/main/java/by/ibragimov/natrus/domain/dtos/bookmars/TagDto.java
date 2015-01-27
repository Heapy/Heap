package by.ibragimov.natrus.domain.dtos.bookmars;

import by.ibragimov.natrus.domain.dtos.BaseDto;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents bookmarks tag.
 */
public final class TagDto implements BaseDto {

    private final String name;

    private final Set<BookmarkDto> bookmarks;

    private final Integer count;

    private TagDto(Builder builder) {
        name = builder.name;
        bookmarks = builder.bookmarks;
        count = builder.count;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public Set<BookmarkDto> getBookmarks() {
        return bookmarks;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TagDto)) {
            return false;
        }

        TagDto tagDto = (TagDto) o;

        if (bookmarks != null ? !bookmarks.equals(tagDto.bookmarks) : tagDto.bookmarks != null) {
            return false;
        }
        if (count != null ? !count.equals(tagDto.count) : tagDto.count != null) {
            return false;
        }
        if (name != null ? !name.equals(tagDto.name) : tagDto.name != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (bookmarks != null ? bookmarks.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TagDto{" + "name='" + name + '\'' + ", bookmarks=" + bookmarks + ", count=" + count + '}';
    }

    public static final class Builder {
        private String name;
        private Set<BookmarkDto> bookmarks = new HashSet<>();
        private Integer count;

        private Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder bookmarks(Set<BookmarkDto> bookmarks) {
            this.bookmarks = bookmarks;
            return this;
        }

        public Builder count(Integer count) {
            this.count = count;
            return this;
        }

        public TagDto build() {
            return new TagDto(this);
        }
    }
}

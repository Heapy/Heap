package by.wth.chkeeper.domain.dtos;

import by.wth.chkeeper.domain.markers.Identified;

public class ItemCategoryDto implements BaseDto, Identified<Long> {

    private final Long id;

    private final String name;

    private ItemCategoryDto(Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ItemCategoryDto copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        return builder;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public static final class Builder {
        private Long id;
        private String name;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public ItemCategoryDto build() {
            return new ItemCategoryDto(this);
        }
    }

}

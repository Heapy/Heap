package by.ibragimov.natrus.domain.rkeep;

public class ItemCategory implements BaseDto, Identified<Long> {

    private final Long id;

    private final String name;

    private ItemCategory(Builder builder) {
        id = builder.id;
        name = builder.name;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(by.wth.chkeeper.domain.dtos.ItemCategory copy) {
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

        public by.wth.chkeeper.domain.dtos.ItemCategory build() {
            return new by.wth.chkeeper.domain.dtos.ItemCategory(this);
        }
    }

}

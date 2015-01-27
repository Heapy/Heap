package by.ibragimov.natrus.domain.rkeep;

public class PlaceItem {

    private final Long id;

    private final String name;

    private final ItemCategory category;

    private final String sku;

    private PlaceItem(Builder builder) {
        id = builder.id;
        name = builder.name;
        category = builder.category;
        sku = builder.sku;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(PlaceItem copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        builder.category = copy.category;
        builder.sku = copy.sku;
        return builder;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public ItemCategory getCategory() {
        return this.category;
    }

    public String getSku() {
        return this.sku;
    }

    @Override
    public String toString() {
        return "PlaceItemDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", sku='" + sku + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaceItem that = (PlaceItem) o;

        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (sku != null ? !sku.equals(that.sku) : that.sku != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        return result;
    }


    public static final class Builder {
        private Long id;
        private String name;
        private ItemCategoryDto category;
        private String sku;

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

        public Builder category(ItemCategoryDto category) {
            this.category = category;
            return this;
        }

        public Builder sku(String sku) {
            this.sku = sku;
            return this;
        }

        public PlaceItem build() {
            return new PlaceItem(this);
        }
    }
}

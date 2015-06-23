package by.ibragimov.heap.domain.rkeep;

import by.ibragimov.heap.domain.common.BaseEntity;

import javax.persistence.Entity;

@Entity
public class PlaceItem extends BaseEntity<PlaceItem> {

    private String name;

    private ItemCategory category;

    private String sku;

    public String getName() {
        return name;
    }

    public PlaceItem setName(String name) {
        this.name = name;
        return this;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public PlaceItem setCategory(ItemCategory category) {
        this.category = category;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public PlaceItem setSku(String sku) {
        this.sku = sku;
        return this;
    }
}

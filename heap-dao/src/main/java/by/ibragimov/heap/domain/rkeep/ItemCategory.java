package by.ibragimov.heap.domain.rkeep;

import by.ibragimov.heap.domain.common.BaseEntity;

import javax.persistence.Entity;

@Entity
public class ItemCategory extends BaseEntity<ItemCategory> {

    private String name;

    public String getName() {
        return name;
    }

    public ItemCategory setName(String name) {
        this.name = name;
        return this;
    }
}

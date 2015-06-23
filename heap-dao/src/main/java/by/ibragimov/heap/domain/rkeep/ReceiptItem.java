package by.ibragimov.heap.domain.rkeep;

import by.ibragimov.heap.domain.common.BaseEntity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class ReceiptItem extends BaseEntity<ReceiptItem> {

    private BigDecimal price;

    private Receipt receipt;

    private PlaceItem item;

    private Boolean isActive;

    public BigDecimal getPrice() {
        return price;
    }

    public ReceiptItem setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public ReceiptItem setReceipt(Receipt receipt) {
        this.receipt = receipt;
        return this;
    }

    public PlaceItem getItem() {
        return item;
    }

    public ReceiptItem setItem(PlaceItem item) {
        this.item = item;
        return this;
    }

    public Boolean isActive() {
        return isActive;
    }

    public ReceiptItem setIsActive(Boolean isActive) {
        this.isActive = isActive;
        return this;
    }
}

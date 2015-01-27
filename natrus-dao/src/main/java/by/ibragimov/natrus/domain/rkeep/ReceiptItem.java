package by.wth.chkeeper.domain.dtos;

import by.wth.chkeeper.domain.markers.Identified;

import java.math.BigDecimal;

public class ReceiptItem implements BaseDto, Identified<Long> {

    private final Long id;

    private final BigDecimal price;

    private final ReceiptDto receipt;

    private final PlaceItemDto item;

    private final Boolean isActive;

    private ReceiptItem(Builder builder) {
        id = builder.id;
        price = builder.price;
        receipt = builder.receipt;
        item = builder.item;
        isActive = builder.isActive;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(by.wth.chkeeper.domain.dtos.ReceiptItem copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.price = copy.price;
        builder.receipt = copy.receipt;
        builder.item = copy.item;
        builder.isActive = copy.isActive;
        return builder;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public ReceiptDto getReceipt() {
        return this.receipt;
    }

    public PlaceItemDto getItem() {
        return this.item;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    @Override
    public String toString() {
        return "ReceiptItemDto{" +
                "id=" + id +
                ", price=" + price +
                ", receipt=" + receipt +
                ", item=" + item +
                ", isActive=" + isActive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        by.wth.chkeeper.domain.dtos.ReceiptItem that = (by.wth.chkeeper.domain.dtos.ReceiptItem) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isActive != null ? !isActive.equals(that.isActive) : that.isActive != null) return false;
        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (receipt != null ? !receipt.equals(that.receipt) : that.receipt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (receipt != null ? receipt.hashCode() : 0);
        result = 31 * result + (item != null ? item.hashCode() : 0);
        result = 31 * result + (isActive != null ? isActive.hashCode() : 0);
        return result;
    }


    public static final class Builder {
        private Long id;
        private BigDecimal price;
        private ReceiptDto receipt;
        private PlaceItemDto item;
        private Boolean isActive;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder receipt(ReceiptDto receipt) {
            this.receipt = receipt;
            return this;
        }

        public Builder item(PlaceItemDto item) {
            this.item = item;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public by.wth.chkeeper.domain.dtos.ReceiptItem build() {
            return new by.wth.chkeeper.domain.dtos.ReceiptItem(this);
        }
    }
}

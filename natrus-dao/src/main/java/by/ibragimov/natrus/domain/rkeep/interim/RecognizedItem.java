package by.ibragimov.natrus.domain.rkeep.interim;

import java.math.BigDecimal;

public class RecognizedItem {

    private String name;

    private BigDecimal price;

    public String getName() {
        return this.name;
    }

    public RecognizedItem setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public RecognizedItem setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "RecognizedItemDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

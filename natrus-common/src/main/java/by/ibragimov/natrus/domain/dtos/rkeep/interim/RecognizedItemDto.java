package by.wth.chkeeper.domain.dtos.interim;

import java.math.BigDecimal;

public class RecognizedItemDto {

    private String name;

    private BigDecimal price;

    public String getName() {
        return this.name;
    }

    public RecognizedItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public RecognizedItemDto setPrice(BigDecimal price) {
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

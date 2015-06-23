package by.ibragimov.heap.domain.rkeep.interim;

import by.ibragimov.heap.domain.common.BaseEntity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class RecognizedItem extends BaseEntity<RecognizedItem> {

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
}

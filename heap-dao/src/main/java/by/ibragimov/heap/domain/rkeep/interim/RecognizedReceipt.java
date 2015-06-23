package by.ibragimov.heap.domain.rkeep.interim;

import by.ibragimov.heap.domain.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RecognizedReceipt extends BaseEntity<RecognizedReceipt> {

    private String place;

    private String date;

    @OneToMany
    private List<RecognizedItem> items = new ArrayList<>();

    public String getPlace() {
        return this.place;
    }

    public RecognizedReceipt setPlace(String place) {
        this.place = place;
        return this;
    }

    public String getDate() {
        return this.date;
    }

    public RecognizedReceipt setDate(String date) {
        this.date = date;
        return this;
    }

    public List<RecognizedItem> getItems() {
        return this.items;
    }

    public RecognizedReceipt setItems(List<RecognizedItem> items) {
        this.items = items;
        return this;
    }
}

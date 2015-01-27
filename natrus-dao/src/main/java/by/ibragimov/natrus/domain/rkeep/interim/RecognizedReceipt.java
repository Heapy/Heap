package by.ibragimov.natrus.domain.rkeep.interim;

import java.util.ArrayList;
import java.util.List;

public class RecognizedReceipt {

    private Long id;

    private String place;

    private String date;

    private List<RecognizedItem> items = new ArrayList<>();

    public Long getId() {
        return this.id;
    }

    public RecognizedReceipt setId(Long id) {
        this.id = id;
        return this;
    }

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

    @Override
    public String toString() {
        return "RecognizedReceiptDto{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", date=" + date +
                ", items=" + items +
                '}';
    }
}

package by.wth.chkeeper.domain.dtos.interim;

import by.wth.chkeeper.domain.dtos.BaseDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecognizedReceiptDto implements BaseDto {

    private Long id;

    private String place;

    private String date;

    private List<RecognizedItemDto> items = new ArrayList<>();

    public Long getId() {
        return this.id;
    }

    public RecognizedReceiptDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPlace() {
        return this.place;
    }

    public RecognizedReceiptDto setPlace(String place) {
        this.place = place;
        return this;
    }

    public String getDate() {
        return this.date;
    }

    public RecognizedReceiptDto setDate(String date) {
        this.date = date;
        return this;
    }

    public List<RecognizedItemDto> getItems() {
        return this.items;
    }

    public RecognizedReceiptDto setItems(List<RecognizedItemDto> items) {
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

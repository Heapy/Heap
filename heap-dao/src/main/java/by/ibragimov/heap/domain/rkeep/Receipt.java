package by.ibragimov.heap.domain.rkeep;

import by.ibragimov.heap.domain.common.BaseEntity;
import by.ibragimov.heap.domain.common.HeapUser;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Receipt extends BaseEntity<Receipt> {

    private Place place;

    private Date date;

    private HeapUser user;

    public Place getPlace() {
        return place;
    }

    public Receipt setPlace(Place place) {
        this.place = place;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Receipt setDate(Date date) {
        this.date = date;
        return this;
    }

    public HeapUser getUser() {
        return user;
    }

    public Receipt setUser(HeapUser user) {
        this.user = user;
        return this;
    }
}

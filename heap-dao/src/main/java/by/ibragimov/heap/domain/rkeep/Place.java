package by.ibragimov.heap.domain.rkeep;

import by.ibragimov.heap.domain.common.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Place extends BaseEntity<Place> {

    private String name;

    private Double latitude;

    private Double longitude;

    public String getName() {
        return name;
    }

    public Place setName(String name) {
        this.name = name;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Place setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Place setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }
}

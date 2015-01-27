package by.ibragimov.natrus.domain.rkeep;


public class Place {

    private final Long id;

    private final String name;

    private final Double latitude;

    private final Double longitude;

    private Place(Builder builder) {
        id = builder.id;
        name = builder.name;
        latitude = builder.latitude;
        longitude = builder.longitude;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Place copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        builder.latitude = copy.latitude;
        builder.longitude = copy.longitude;
        return builder;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    @Override
    public String toString() {
        return "PlaceDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (id != null ? !id.equals(place.id) : place.id != null) return false;
        if (latitude != null ? !latitude.equals(place.latitude) : place.latitude != null) return false;
        if (longitude != null ? !longitude.equals(place.longitude) : place.longitude != null) return false;
        if (name != null ? !name.equals(place.name) : place.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }


    public static final class Builder {
        private Long id;
        private String name;
        private Double latitude;
        private Double longitude;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder latitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder longitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public Place build() {
            return new Place(this);
        }
    }
}

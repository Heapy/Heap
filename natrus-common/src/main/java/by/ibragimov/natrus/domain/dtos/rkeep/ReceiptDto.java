package by.wth.chkeeper.domain.dtos;

import by.wth.chkeeper.domain.markers.Identified;

import java.util.Date;

public class ReceiptDto implements BaseDto, Identified<Long> {

    private final Long id;

    private final PlaceDto place;

    private final Date date;

    private final UserDto user;

    private ReceiptDto(Builder builder) {
        id = builder.id;
        place = builder.place;
        date = builder.date;
        user = builder.user;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ReceiptDto copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.place = copy.place;
        builder.date = copy.date;
        builder.user = copy.user;
        return builder;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public PlaceDto getPlace() {
        return this.place;
    }

    public Date getDate() {
        return this.date;
    }

    public UserDto getUser() {
        return this.user;
    }

    @Override
    public String toString() {
        return "ReceiptDto{" +
                "id=" + id +
                ", place=" + place +
                ", date=" + date +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiptDto that = (ReceiptDto) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (place != null ? !place.equals(that.place) : that.place != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }


    public static final class Builder {
        private Long id;
        private PlaceDto place;
        private Date date;
        private UserDto user;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder place(PlaceDto place) {
            this.place = place;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder user(UserDto user) {
            this.user = user;
            return this;
        }

        public ReceiptDto build() {
            return new ReceiptDto(this);
        }
    }
}

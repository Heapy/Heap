package by.ibragimov.natrus.domain.rkeep.interim;

import by.ibragimov.natrus.domain.common.Client;

import java.sql.Timestamp;

public class ReceiptImage {

    private final Long id;

    private final String image;

    private final Client client;

    private final Boolean isDone;

    private final Timestamp startTime;

    private ReceiptImage(Builder builder) {
        id = builder.id;
        image = builder.image;
        client = builder.userDto;
        isDone = builder.isDone;
        startTime = builder.startTime;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(ReceiptImage copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.image = copy.image;
        builder.userDto = copy.client;
        builder.isDone = copy.isDone;
        builder.startTime = copy.startTime;
        return builder;
    }

    public Long getId() {
        return this.id;
    }

    public String getImage() {
        return this.image;
    }

    public Client getClient() {
        return this.client;
    }

    public Boolean getIsDone() {
        return this.isDone;
    }

    public Timestamp getStartTime() {
        return this.startTime;
    }

    @Override
    public String toString() {
        return "ReceiptImageDto{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", client=" + client +
                ", isDone=" + isDone +
                ", startTime=" + startTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReceiptImage that = (ReceiptImage) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (isDone != null ? !isDone.equals(that.isDone) : that.isDone != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;
        if (client != null ? !client.equals(that.client) : that.client != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (isDone != null ? isDone.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        return result;
    }


    public static final class Builder {
        private Long id;
        private String image;
        private Client userDto;
        private Boolean isDone;
        private Timestamp startTime;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public Builder userDto(Client userDto) {
            this.userDto = userDto;
            return this;
        }

        public Builder isDone(Boolean isDone) {
            this.isDone = isDone;
            return this;
        }

        public Builder startTime(Timestamp startTime) {
            this.startTime = startTime;
            return this;
        }

        public ReceiptImage build() {
            return new ReceiptImage(this);
        }
    }
}

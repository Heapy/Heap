package by.ibragimov.natrus.domain.dtos.users;

import by.ibragimov.natrus.domain.dtos.BaseDto;
import by.ibragimov.natrus.domain.markers.Identified;

/**
 * Represents single user.
 */
public final class UserDto implements Identified<Long>, BaseDto {

    private final Long id;

    private final String login;

    private final String token;

    private UserDto(Builder builder) {
        id = builder.id;
        login = builder.login;
        token = builder.token;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserDto)) {
            return false;
        }

        UserDto userDto = (UserDto) o;

        if (!id.equals(userDto.id)) {
            return false;
        }
        if (!login.equals(userDto.login)) {
            return false;
        }
        if (token != null ? !token.equals(userDto.token) : userDto.token != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDto{" + "id=" + id + ", login='" + login + '\'' + ", token='" + token + '\'' + '}';
    }

    public static final class Builder {
        private Long id;
        private String login;
        private String token;

        private Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }
}

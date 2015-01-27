package by.wth.chkeeper.domain.dtos;

import by.wth.chkeeper.domain.markers.Identified;

/**
 * Represents single user.
 */
public final class UserDto implements Identified<Long>, BaseDto {

    private final Long id;

    private final String login;

    private final String password;

    private final String salt;

    private UserDto(Builder builder) {
        id = builder.id;
        login = builder.login;
        password = builder.password;
        salt = builder.salt;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(UserDto copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.login = copy.login;
        builder.password = copy.password;
        builder.salt = copy.salt;
        return builder;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public String getSalt() {
        return this.salt;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDto = (UserDto) o;

        if (id != null ? !id.equals(userDto.id) : userDto.id != null) return false;
        if (login != null ? !login.equals(userDto.login) : userDto.login != null) return false;
        if (password != null ? !password.equals(userDto.password) : userDto.password != null) return false;
        if (salt != null ? !salt.equals(userDto.salt) : userDto.salt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        return result;
    }

    public static final class Builder {
        private Long id;
        private String login;
        private String password;
        private String salt;

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

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder salt(String salt) {
            this.salt = salt;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }
}

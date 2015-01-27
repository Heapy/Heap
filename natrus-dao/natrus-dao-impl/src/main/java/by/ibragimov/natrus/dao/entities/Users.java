package by.ibragimov.natrus.dao.entities;

import javax.persistence.Entity;

@Entity
public class Users extends BaseEntity<Users> {

    private String login;

    public String getLogin() {
        return this.login;
    }

    public Users setLogin(String login) {
        this.login = login;
        return this;
    }
}

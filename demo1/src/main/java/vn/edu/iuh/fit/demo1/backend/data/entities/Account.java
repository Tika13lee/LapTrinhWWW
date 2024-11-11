package vn.edu.iuh.fit.demo1.backend.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "select a from Account a"),
        @NamedQuery(name = "Account.findByUsername", query = "select a from Account a where a.username = :username"),
        @NamedQuery(name = "Account.deleteById", query = "delete from Account a where a.id = :id")
})
public class Account {
    @Id
    @Column(name = "id")
    private String id;
    private String username;
    private String password;

    public Account() {
    }

    public Account(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

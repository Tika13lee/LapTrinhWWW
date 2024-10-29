package vn.edu.iuh.fit.backend.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "select a from Account a"),
        @NamedQuery(name = "Account.deleteByUsername", query = "delete from Account a where a.username = :username"),
        @NamedQuery(name = "Account.deleteById", query = "delete from Account a where a.id = :id"),
        @NamedQuery(name = "Account.findByUsername", query = "select a from Account a where a.username = :username"),
        @NamedQuery(name = "Account.findByBalance", query = "select a from Account a where a.id >= :min and a.id <= :max")
})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

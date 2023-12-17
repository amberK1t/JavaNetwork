package org.top.onlinestoreapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_t")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login_f", nullable = false)
    private String login;

    @Column(name = "password_f", nullable = false)
    private String password;

    @Column(name = "role_f", nullable = false)
    private String role;

    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public User() {
        this.id = 0;
        this.login = "";
        this.password = "";
        this.role = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

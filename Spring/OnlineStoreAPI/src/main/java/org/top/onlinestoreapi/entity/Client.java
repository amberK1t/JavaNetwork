package org.top.onlinestoreapi.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "client_t")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_f")
    private String name;

    @Column(name = "phone_f")
    private Integer phoneNumber;

    @Column(name = "email_f")
    private String email;

    @OneToMany(mappedBy = "client")
    private Set<Order> orderSet;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Feedback> feedbackSet;

    public Client() {
        this.id = 0;
        this.name = "";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public Set<Feedback> getFeedbackSet() {
        return feedbackSet;
    }

    public void setFeedbackSet(Set<Feedback> feedbackSet) {
        this.feedbackSet = feedbackSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

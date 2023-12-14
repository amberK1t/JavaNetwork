package org.top.onlinestoreapi.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "order_t")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "desc_f")
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "order")
    private Set<Position> positionSet;

    public Order() {
        this.id = 0;
        this.description = "";
        this.client = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Position> getPositionSet() {
        return positionSet;
    }

    public void setPositionSet(Set<Position> positionSet) {
        this.positionSet = positionSet;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", client=" + client +
                ", positionSet=" + positionSet +
                '}';
    }
}

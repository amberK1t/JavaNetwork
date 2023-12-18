package org.top.onlinestoreapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "position_t")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity_f")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    public Position() {
        id = 0;
        quantity = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }



    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", order=" + order +
                ", item=" + item +
                '}';
    }
}

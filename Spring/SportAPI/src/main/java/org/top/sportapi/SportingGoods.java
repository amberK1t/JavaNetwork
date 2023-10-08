package org.top.sportapi;

import jakarta.persistence.*;

@Entity
@Table(name = "sport_t")
public class SportingGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title_f", nullable = false)
    private String title;

    @Column(name = "price_f", nullable = false)
    private Integer price;

    @Column(name = "type_f", nullable = false)
    private String type;

    @Column(name = "quantity_f", nullable = false)
    private Integer quantity;

    @Column(name = "description_f")
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return id + " - " + title + " - " + price + " - " + type + " - " + quantity + " - " + description;
    }
}

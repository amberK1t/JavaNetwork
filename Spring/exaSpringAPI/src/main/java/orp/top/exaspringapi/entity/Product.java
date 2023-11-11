package orp.top.exaspringapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product_t")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title_f", nullable = false)
    private String title;

    @Column(name = "price_f", nullable = false)
    private Double price;

    @Column(name = "exist_f", nullable = false)
    private Boolean existence;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<ProductOrder> productOrders;

    public Product() {
        id = 0;
        title = "";
        price = 0.0;
        existence = false;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getExistence() {
        return existence;
    }

    public void setExistence(Boolean existence) {
        this.existence = existence;
    }
}

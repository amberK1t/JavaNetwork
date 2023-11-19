package org.top.hotelscatalog.entity;

import jakarta.persistence.*;

// Hotel описывает сущность "Отель" - запись таблицы отелей
@Entity
@Table(name = "hotel_t")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name_f", nullable = false)
    private String name;    // Наимнование отеля

    @Column(name="address_f", nullable = false)
    private String address; // Адрес отеля

    @Column(name="classification_f")
    private Integer classification; // Кол-во звезд отеля

    @Column(name="rate_f", nullable = false)
    private Double rate;    // Рейтинг отеля

    // конструкторы
    public Hotel() {
        id = 0;
        name = "";
        address = "";
        classification = null;
        rate = 0.0;
    }

    // getters & setters

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    // ToString

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", classification=" + classification +
                ", rate=" + rate +
                '}';
    }
}

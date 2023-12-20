package org.top.onlinestoreapi.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "item_t")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_f")
    private String name;

    @Column(name = "country_f")
    private String countryOfOrigin;

    @Column(name = "guarantee_f")
    private Integer guarantee;

    @Column(name = "release_f")
    private Integer releaseYear;

    @Column(name = "diagonal_f")
    private Double diagonal;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "img_f", columnDefinition = "MEDIUMBLOB")
    private String imgData;

    @Column(name = "price_f")
    private Integer price;

    @OneToMany(mappedBy = "item")
    private Set<Position> positionSet;

    @OneToMany(mappedBy = "item")
    private Set<Feedback> feedbackSet;

    public Item() {
        this.id = 0;
        this.name = "";
        this.countryOfOrigin = "";
        this.guarantee = 0;
        this.releaseYear = 0;
        this.diagonal = 0.0;
        this.type = "";
        this.imgData = null;
        this.price = 0;
    }

    public Set<Feedback> getFeedbackSet() {
        return feedbackSet;
    }

    public void setFeedbackSet(Set<Feedback> feedbackSet) {
        this.feedbackSet = feedbackSet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Position> getPositionSet() {
        return positionSet;
    }

    public void setPositionSet(Set<Position> positionSet) {
        this.positionSet = positionSet;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImgData() {
        return imgData;
    }

    public void setImgData(String imgData) {
        this.imgData = imgData;
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

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public Integer getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(Integer guarantee) {
        this.guarantee = guarantee;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Double diagonal) {
        this.diagonal = diagonal;
    }



    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                ", guarantee=" + guarantee +
                ", releaseYear=" + releaseYear +
                ", diagonal=" + diagonal +
                ", price=" + price +
                '}';
    }
}

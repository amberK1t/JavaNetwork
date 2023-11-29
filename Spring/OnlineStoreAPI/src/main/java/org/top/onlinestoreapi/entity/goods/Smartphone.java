package org.top.onlinestoreapi.entity.goods;

import jakarta.persistence.*;

@Entity
@Table(name = "item_t")
public class Smartphone {

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

    @Column(name = "proc_f")
    private String processor;

    @Column(name = "ram_f")
    private Integer ram;

    @Column(name = "rom_f")
    private  Integer rom;

    @Column(name = "img_f")
    private String img;

    @Column(name = "price_f")
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getRom() {
        return rom;
    }

    public void setRom(Integer rom) {
        this.rom = rom;
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
                ", processor='" + processor + '\'' +
                ", ram=" + ram +
                ", rom=" + rom +
                '}';
    }
}

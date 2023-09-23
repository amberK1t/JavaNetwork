package org.top.proglangdbdriver.entity;

public class Language {
    private Integer id;
    private String name;
    private String version;
    private Integer year;
    private String author;

    public Language(Integer id, String name, String version, Integer year, String author) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.year = year;
        this.author = author;
    }

    public Language(String name, String version, Integer year, String author) {
        this.name = name;
        this.version = version;
        this.year = year;
        this.author = author;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + version + " - " + year + " - " + author;
    }
}

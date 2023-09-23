package org.top.music_catalog.entity;

public class Song {
    private Integer id;
    private String title;
    private String singer;
    private String authorship;
    private Integer year;
    private Integer duration;

    public Song(Integer id, String title, String singer, String authorship, Integer year, Integer duration) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.authorship = authorship;
        this.year = year;
        this.duration = duration;
    }

    public Song(String title, String singer, String authorship, Integer year, Integer duration) {
        this.title = title;
        this.singer = singer;
        this.authorship = authorship;
        this.year = year;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public String getAuthorship() {
        return authorship;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setAuthorship(String authorship) {
        this.authorship = authorship;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", authorship='" + authorship + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                '}';
    }
}

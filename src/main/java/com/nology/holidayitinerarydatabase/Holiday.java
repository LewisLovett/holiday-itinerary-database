package com.nology.holidayitinerarydatabase;

import javax.persistence.*;


@Entity
public class Holiday {
    @Id
    private int id;
    private String location;
    private String date;
    private String author;
    private String description;

    public Holiday(){

    }
    public Holiday(int id, String location, String date, String author, String description) {
        this.id = id;
        this.location = location;
        this.date = date;
        this.author = author;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

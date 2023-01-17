package com.nology.holidayItinerary.model;



import javax.persistence.*;


@Entity
@Table(name="Holiday")
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "holiday_generator")
    private long id;
    @Column(name = "location")
    private String location;
    @Column(name = "date")
    private String date;
    @Column(name = "author")
    private String author;
    @Column(name = "description")
    private String description;

    public Holiday(){

    }
    public Holiday( String location, String date, String author, String description) {
        this.location = location;
        this.date = date;
        this.author = author;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

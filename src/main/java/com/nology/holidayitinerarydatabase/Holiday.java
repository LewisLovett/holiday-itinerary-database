package com.nology.holidayitinerarydatabase;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name="holiday")
public class Holiday {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String location;
    private String date;
    private String author;
    private String description;
}

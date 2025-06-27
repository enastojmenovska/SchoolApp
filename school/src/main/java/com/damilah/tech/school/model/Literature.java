package com.damilah.tech.school.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="literature")
public class Literature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;


    public Literature() {

    }

    public Literature(String title, String author,String publisher, int publicationYear) {
        this.title = title;
        this.author=author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
    }

}

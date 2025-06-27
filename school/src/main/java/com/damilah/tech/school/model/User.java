package com.damilah.tech.school.model;

import com.damilah.tech.school.model.enumerations.YearStudies;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirth;
    private String course;
    @Enumerated(EnumType.STRING)
    private YearStudies yearStudies;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Subject> subjects;

    public User() {
    }

    public User(String username, String password, String name, String surname, String email, LocalDate dateOfBirth, String course, YearStudies yearStudies) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.course = course;
        this.yearStudies = yearStudies;
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public void removeSubject(Subject subject){
        subjects.remove(subject);
    }
}

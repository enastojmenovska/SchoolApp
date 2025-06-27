package com.damilah.tech.school.model;

import com.damilah.tech.school.model.enumerations.SubjectLevel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int numWeeklyClasses;
    @Enumerated(EnumType.STRING)
    private SubjectLevel level;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "subject_literature",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "literature_id")
    )
    private List<Literature> literatureList;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "subject_professors",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id")
    )
    private List<Professor> professors;

    public Subject() {
    }

    public Subject(String name, String description, int numWeeklyClasses, SubjectLevel level) {
        this.name = name;
        this.description = description;
        this.numWeeklyClasses = numWeeklyClasses;
        this.level = level;
        this.literatureList=new ArrayList<>();
        this.professors=new ArrayList<>();
    }

    public void addLiterature(Literature literature){
        this.literatureList.add(literature);
    }

    public void addProfessor(Professor professor){
        this.professors.add(professor);
    }

}

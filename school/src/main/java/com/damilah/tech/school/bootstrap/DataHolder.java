package com.damilah.tech.school.bootstrap;

import com.damilah.tech.school.model.Literature;
import com.damilah.tech.school.model.Professor;
import com.damilah.tech.school.model.Subject;
import com.damilah.tech.school.model.User;
import com.damilah.tech.school.model.enumerations.SubjectLevel;
import com.damilah.tech.school.model.enumerations.YearStudies;
import com.damilah.tech.school.repository.LiteratureRepository;
import com.damilah.tech.school.repository.ProfessorRepository;
import com.damilah.tech.school.repository.SubjectRepository;
import com.damilah.tech.school.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<User> users = null;
    public static List<Subject> subjects = null;
    public static List<Professor> professors = null;
    public static List<Literature> literature = null;

    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;
    private final LiteratureRepository literatureRepository;

    public DataHolder(UserRepository userRepository, SubjectRepository subjectRepository, ProfessorRepository professorRepository, LiteratureRepository literatureRepository) {
        this.userRepository = userRepository;
        this.subjectRepository = subjectRepository;
        this.professorRepository = professorRepository;
        this.literatureRepository = literatureRepository;
    }

    @PostConstruct
    public void init(){
        users=new ArrayList<>();
        subjects=new ArrayList<>();
        professors=new ArrayList<>();
        literature=new ArrayList<>();

        if(userRepository.count()==0){
            users.add(new User("ena.stojmenovska","es","Ena","Stojmenovska","ena_stojmenovska@icloud.com", LocalDate.of(2001,8,19),"Computer science", YearStudies.FOURTH));
            this.userRepository.saveAll(users);
        }

        if(literatureRepository.count()==0){
            //Algorithms and data structures
            literature.add(new Literature("The Algorithm Design Manual","Steven S. Skiena","Springer",2008));
            literature.add(new Literature("Data structures and algorithms", "Alfred V. Aho, Jeffrey D. Ullman, John E. Hopcroft","Addison Wesley",1983));
            //Object-oriented programing
            literature.add(new Literature("Starting Out with C++: Early Objects", "Tony Gaddis, Judy Walters, Godfrey Muganda","Pearson",2019));
            literature.add(new Literature("The C++ Programming Language", "Bjarne Stroustrup","Addison Wesley",2013));
            //Data bases
            literature.add(new Literature("An Introduction to Database Systems", "Christopher J. Date","Pearson",2003));
            //Web programming
            literature.add(new Literature("Spring in Action Fifth Edition", "Craig Walls","Manning Publishing",2017));
            literature.add(new Literature("Modern Java Web Development", "Layka, Vishal","Apress",2014));
            //Advanced programming
            literature.add(new Literature("Java 8 in Action: Lambdas, Streams, and Functional-style Programming", "Alan Mycroft, Mario Fusco","Manning Publication",2015));
            this.literatureRepository.saveAll(literature);
        }

        if(professorRepository.count()==0){
            professors.add(new Professor("ProfessorName1","ProfessorSurname1","professor1@test.com"));
            professors.add(new Professor("ProfessorName2","ProfessorSurname2","professor2@test.com"));
            professors.add(new Professor("ProfessorName3","ProfessorSurname3","professor3@test.com"));
            this.professorRepository.saveAll(professors);
        }

        if(subjectRepository.count()==0){
            //SUBJECT1
            subjects.add(new Subject("Algorithms and data structures","Algorithms and data structures Description",4, SubjectLevel.L2));

            subjects.get(0).addLiterature(literature.get(0));
            subjects.get(0).addLiterature(literature.get(1));

            subjects.get(0).addProfessor(professors.get(0));
            subjects.get(0).addProfessor(professors.get(1));

            //SUBJECT2
            subjects.add(new Subject("Object-oriented programing","Object-oriented programing Description",4, SubjectLevel.L1));

            subjects.get(1).addLiterature(literature.get(2));
            subjects.get(1).addLiterature(literature.get(3));

            subjects.get(1).addProfessor(professors.get(0));
            subjects.get(1).addProfessor(professors.get(1));

            //SUBJECT3
            subjects.add(new Subject("Data bases","Data bases Description",5, SubjectLevel.L3));

            subjects.get(2).addLiterature(literature.get(4));

            subjects.get(2).addProfessor(professors.get(2));

            //SUBJECT4
            subjects.add(new Subject("Web programming","Web programming Description",6, SubjectLevel.L3));

            subjects.get(3).addLiterature(literature.get(5));
            subjects.get(3).addLiterature(literature.get(6));

            subjects.get(3).addProfessor(professors.get(2));

            //SUBJECT5
            subjects.add(new Subject("Advanced programming","Advanced programming Description",4, SubjectLevel.L3));

            subjects.get(4).addLiterature(literature.get(7));

            subjects.get(4).addProfessor(professors.get(0));

            this.subjectRepository.saveAll(subjects);
        }
    }
}

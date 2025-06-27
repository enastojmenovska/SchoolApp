package com.damilah.tech.school.service;

import com.damilah.tech.school.model.Subject;
import com.damilah.tech.school.model.User;
import com.damilah.tech.school.model.enumerations.YearStudies;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findByUsername(String username);
    Optional<User> save(String username, String password, String name, String surname, String email, LocalDate dateOfBirth, String course, YearStudies yearStudies);
    List<Subject> listSubjectsOfUser(String username);
    Optional<User> addSubjectToUser(Long idSubject, String username);
    Optional<User> removeSubjectFromUser(Long idSubject, String username);
    void deleteById(String username);
}

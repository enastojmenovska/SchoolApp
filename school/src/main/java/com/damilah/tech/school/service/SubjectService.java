package com.damilah.tech.school.service;

import com.damilah.tech.school.model.Subject;
import com.damilah.tech.school.model.enumerations.SubjectLevel;

import java.util.List;
import java.util.Optional;

public interface SubjectService {
    List<Subject> findAll();
    List<Subject> filterByName(String name);
    Optional<Subject> findById(Long id);
    Optional<Subject> save(String name, String description, int numWeeklyClasses, SubjectLevel level, List<Long> idProfessors,List<Long> idLiterature);
    Optional<Subject> edit(Long id,String name, String description, int numWeeklyClasses, SubjectLevel level, List<Long> idProfessors,List<Long> idLiterature);
    void deleteById(Long id);
}

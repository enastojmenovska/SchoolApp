package com.damilah.tech.school.service;

import com.damilah.tech.school.model.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {
    List<Professor> findAll();
    Optional<Professor> findById(Long id);
    Optional<Professor> save(String name, String surname,String email);
    Optional<Professor> edit(Long id,String name, String surname,String email);
    void deleteById(Long id);
}

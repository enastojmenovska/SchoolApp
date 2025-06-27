package com.damilah.tech.school.service.impl;

import com.damilah.tech.school.model.Professor;
import com.damilah.tech.school.model.exception.ProfessorNotFoundException;
import com.damilah.tech.school.repository.ProfessorRepository;
import com.damilah.tech.school.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<Professor> findAll() {
        return this.professorRepository.findAll();
    }

    @Override
    public Optional<Professor> findById(Long id) {
        return this.professorRepository.findById(id);
    }

    @Override
    public Optional<Professor> save(String name, String surname, String email) {
        return Optional.of(this.professorRepository.save(new Professor(name,surname,email)));
    }

    @Override
    public Optional<Professor> edit(Long id, String name, String surname, String email) {
        Professor professor=this.findById(id).orElseThrow(()->new ProfessorNotFoundException(id));
        professor.setName(name);
        professor.setSurname(surname);
        professor.setEmail(email);
        this.professorRepository.save(professor);
        return Optional.of(professor);
    }

    @Override
    public void deleteById(Long id) {
        this.findById(id).orElseThrow(()->new ProfessorNotFoundException(id));
        this.professorRepository.deleteById(id);
    }
}

package com.damilah.tech.school.service.impl;

import com.damilah.tech.school.model.Literature;
import com.damilah.tech.school.model.Professor;
import com.damilah.tech.school.model.Subject;
import com.damilah.tech.school.model.enumerations.SubjectLevel;
import com.damilah.tech.school.model.exception.LiteratureNotFoundException;
import com.damilah.tech.school.model.exception.ProfessorNotFoundException;
import com.damilah.tech.school.model.exception.SubjectNotFoundException;
import com.damilah.tech.school.repository.SubjectRepository;
import com.damilah.tech.school.service.LiteratureService;
import com.damilah.tech.school.service.ProfessorService;
import com.damilah.tech.school.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;
    private final ProfessorService professorService;
    private final LiteratureService literatureService;

    public SubjectServiceImpl(SubjectRepository subjectRepository, ProfessorService professorService, LiteratureService literatureService) {
        this.subjectRepository = subjectRepository;
        this.professorService = professorService;
        this.literatureService = literatureService;
    }

    @Override
    public List<Subject> findAll() {
        return this.subjectRepository.findAll();
    }

    @Override
    public List<Subject> filterByName(String name) {
        return this.subjectRepository.findByNameContaining(name);
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return this.subjectRepository.findById(id);
    }

    @Override
    public Optional<Subject> save(String name, String description, int numWeeklyClasses, SubjectLevel level, List<Long> idProfessors, List<Long> idLiterature) {
        Subject subject=new Subject(name,description,numWeeklyClasses,level);
        addProfessorsAndLiterature(idProfessors, idLiterature, subject);
        return Optional.of(this.subjectRepository.save(subject));
    }

    @Override
    public Optional<Subject> edit(Long id, String name, String description, int numWeeklyClasses, SubjectLevel level, List<Long> idProfessors,List<Long> idLiterature) {
        Subject subject=this.findById(id).orElseThrow(()-> new SubjectNotFoundException(id));
        subject.setName(name);
        subject.setDescription(description);
        subject.setNumWeeklyClasses(numWeeklyClasses);
        subject.setLevel(level);

        addProfessorsAndLiterature(idProfessors, idLiterature, subject);
        return Optional.of(this.subjectRepository.save(subject));
    }

    public void addProfessorsAndLiterature(List<Long> idProfessors, List<Long> idLiterature, Subject subject) {
        idProfessors.forEach(professorId->{
            Professor professor= this.professorService.findById(professorId).orElseThrow(()->new ProfessorNotFoundException(professorId));
            subject.addProfessor(professor);
        });
        idLiterature.forEach(literatureId->{
            Literature literature=this.literatureService.findById(literatureId).orElseThrow(()-> new LiteratureNotFoundException(literatureId));
            subject.addLiterature(literature);
        });
    }

    @Override
    public void deleteById(Long id) {
        this.findById(id).orElseThrow(()->new SubjectNotFoundException(id));
        this.subjectRepository.deleteById(id);
    }
}

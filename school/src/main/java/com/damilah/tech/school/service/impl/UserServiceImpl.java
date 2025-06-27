package com.damilah.tech.school.service.impl;

import com.damilah.tech.school.model.Subject;
import com.damilah.tech.school.model.User;
import com.damilah.tech.school.model.enumerations.YearStudies;
import com.damilah.tech.school.model.exception.SubjectNotFoundException;
import com.damilah.tech.school.model.exception.UserNotFoundException;
import com.damilah.tech.school.repository.UserRepository;
import com.damilah.tech.school.service.SubjectService;
import com.damilah.tech.school.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SubjectService subjectService;

    public UserServiceImpl(UserRepository userRepository, SubjectService subjectService) {
        this.userRepository = userRepository;
        this.subjectService = subjectService;
    }


    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }


    @Override
    public Optional<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> save(String username, String password, String name, String surname, String email, LocalDate dateOfBirth, String course, YearStudies yearStudies) {
        return Optional.of(this.userRepository.save(new User(username,password,name,surname,email,dateOfBirth,course,yearStudies)));
    }


    @Override
    public List<Subject> listSubjectsOfUser(String username) {
        User user= this.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
        return user.getSubjects();
    }

    @Override
    public Optional<User> addSubjectToUser(Long idSubject, String username) {
        User user= this.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
        Subject subject= this.subjectService.findById(idSubject).orElseThrow(()->new SubjectNotFoundException(idSubject));
        user.addSubject(subject);
        userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public Optional<User> removeSubjectFromUser(Long idSubject, String username) {
        User user= this.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
        Subject subject= this.subjectService.findById(idSubject).orElseThrow(()->new SubjectNotFoundException(idSubject));
        user.removeSubject(subject);
        userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public void deleteById(String username) {
        this.findByUsername(username).orElseThrow(()->new UserNotFoundException(username));
        this.userRepository.deleteByUsername(username);
    }
}

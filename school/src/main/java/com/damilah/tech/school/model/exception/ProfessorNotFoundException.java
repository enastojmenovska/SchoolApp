package com.damilah.tech.school.model.exception;

public class ProfessorNotFoundException extends RuntimeException{
    public ProfessorNotFoundException(Long id) {
        super(String.format("Professor with id: %d is not found!",id));
    }
}


package com.damilah.tech.school.model.exception;

public class SubjectNotFoundException extends RuntimeException{
    public SubjectNotFoundException(Long id) {
        super(String.format("Subject with id: %d is not found!",id));
    }
}
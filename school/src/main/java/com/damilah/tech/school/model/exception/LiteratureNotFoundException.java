package com.damilah.tech.school.model.exception;

public class LiteratureNotFoundException  extends RuntimeException{
    public LiteratureNotFoundException(Long id) {
        super(String.format("Literature with id: %d is not found!",id));
    }
}

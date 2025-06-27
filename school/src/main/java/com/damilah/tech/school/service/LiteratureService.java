package com.damilah.tech.school.service;

import com.damilah.tech.school.model.Literature;

import java.util.List;
import java.util.Optional;

public interface LiteratureService {
    List<Literature> findAll();
    Optional<Literature> findById(Long id);
    Optional<Literature> save(String title, String author,String publisher, int publicationYear);
    Optional<Literature> edit(Long id,String title, String author,String publisher, int publicationYear);
    void deleteById(Long id);
}

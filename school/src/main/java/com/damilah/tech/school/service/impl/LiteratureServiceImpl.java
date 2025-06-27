package com.damilah.tech.school.service.impl;

import com.damilah.tech.school.model.Literature;
import com.damilah.tech.school.model.exception.LiteratureNotFoundException;
import com.damilah.tech.school.repository.LiteratureRepository;
import com.damilah.tech.school.service.LiteratureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiteratureServiceImpl implements LiteratureService {
    private final LiteratureRepository literatureRepository;

    public LiteratureServiceImpl(LiteratureRepository literatureRepository) {
        this.literatureRepository = literatureRepository;
    }

    @Override
    public List<Literature> findAll() {
        return this.literatureRepository.findAll();
    }

    @Override
    public Optional<Literature> findById(Long id) {
        return this.literatureRepository.findById(id);
    }

    @Override
    public Optional<Literature> save(String title, String author, String publisher, int publicationYear) {
        return Optional.of(this.literatureRepository.save(new Literature(title,author,publisher,publicationYear)));
    }

    @Override
    public Optional<Literature> edit(Long id, String title, String author, String publisher, int publicationYear) {
        Literature literature=this.findById(id).orElseThrow(()-> new LiteratureNotFoundException(id));
        literature.setTitle(title);
        literature.setAuthor(author);
        literature.setPublisher(publisher);
        literature.setPublicationYear(publicationYear);
        this.literatureRepository.save(literature);
        return Optional.of(literature);
    }

    @Override
    public void deleteById(Long id) {
        this.findById(id).orElseThrow(()-> new LiteratureNotFoundException(id));
        this.literatureRepository.deleteById(id);
    }
}

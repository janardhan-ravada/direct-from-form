package com.springboot.poc.service.impl;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.poc.model.Author;
import com.springboot.poc.repository.AuthorRepository;
import com.springboot.poc.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @Transactional
    public Author getAuthorById(Long id) {
        Objects.requireNonNull(id);
        return authorRepository.findOne(id);
    }

    @Override
    @Transactional
    public Author getAuthorByName(String name) {
        Objects.requireNonNull(name);
        return authorRepository.findByName(name);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

}

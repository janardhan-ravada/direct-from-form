package com.springboot.poc.service;

import java.util.List;

import com.springboot.poc.model.Author;

public interface AuthorService {

    public Author getAuthorById(Long id);

    public Author getAuthorByName(String name);

    public List<Author> getAllAuthors();

    public Author addAuthor(Author author);
}

package com.springboot.poc.service;

import java.util.List;

import com.springboot.poc.model.Book;

public interface BookService {
    public Book createBook(Book book);
    public List<Book> getAllBooks();
    public Book getBook(Long id);
}

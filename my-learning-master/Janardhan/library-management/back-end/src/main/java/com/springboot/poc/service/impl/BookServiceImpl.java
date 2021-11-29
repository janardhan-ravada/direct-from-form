package com.springboot.poc.service.impl;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.poc.model.Book;
import com.springboot.poc.repository.BookRepository;
import com.springboot.poc.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    @Transactional
    public Book createBook(Book book) {
        Objects.requireNonNull(book.getTitle());
        Objects.requireNonNull(book.getIsbnNumber());
        Objects.requireNonNull(book.getPrice());

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findOne(id);
    }

}

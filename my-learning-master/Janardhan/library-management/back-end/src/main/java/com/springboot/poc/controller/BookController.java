package com.springboot.poc.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.poc.mapper.BookRequestToBookMapper;
import com.springboot.poc.mapper.BookToBookResourceMapper;
import com.springboot.poc.model.Book;
import com.springboot.poc.request.BookRequest;
import com.springboot.poc.resource.BookResource;
import com.springboot.poc.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRequestToBookMapper bookRequestToBookMapper;

    @Autowired
    private BookToBookResourceMapper bookToBookResourceMapper;

    @RequestMapping(value = "", method = RequestMethod.POST)
    private BookResource createBook(@RequestBody BookRequest bookRequest) {
        System.out.println("creating book");

        Book book = bookRequestToBookMapper.apply(bookRequest);
        bookService.createBook(book);
        return bookToBookResourceMapper.apply(book);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    private Iterable<BookResource> getBooks() {
        return bookService.getAllBooks().stream().map(bookToBookResourceMapper)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private BookResource getBook(@PathVariable Long id) {
        System.out.println("Bookid"+id);
        return bookToBookResourceMapper.apply(bookService.getBook(id));
    }
}

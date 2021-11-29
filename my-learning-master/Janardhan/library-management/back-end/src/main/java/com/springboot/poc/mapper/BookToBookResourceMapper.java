package com.springboot.poc.mapper;

import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.poc.model.Author;
import com.springboot.poc.model.Book;
import com.springboot.poc.model.Publisher;
import com.springboot.poc.resource.AuthorResource;
import com.springboot.poc.resource.BookResource;
import com.springboot.poc.resource.PublisherResource;

@Service
public class BookToBookResourceMapper implements Function<Book, BookResource> {

    @Autowired
    private AuthorToAuthorResourceMapper authorToAuthorResourceMapper;

    @Autowired
    private PublisherToPublisherResourceMapper publisherToPublisherResourceMapper;

    @Override
    public BookResource apply(Book book) {

        Objects.requireNonNull(book);

        Long id = book.getId();
        Objects.requireNonNull(id);

        String title = book.getTitle();
        Objects.requireNonNull(title);

        String isbnNumber = book.getIsbnNumber();
        Objects.requireNonNull(isbnNumber);

        Long totalStock = book.getTotalStock();
        Objects.requireNonNull(totalStock);

        Long availableStock = book.getAvailableStock();
        Objects.requireNonNull(availableStock);

        Double price = book.getPrice();
        Objects.requireNonNull(price);

        Set<Author> authors = book.getAuthors();
        Set<AuthorResource> authorResources = authors.stream()
                .map(authorToAuthorResourceMapper).collect(Collectors.toSet());

        Publisher publisher = book.getPublisher();
        Objects.requireNonNull(publisher);

        PublisherResource publisherResource = publisherToPublisherResourceMapper
                .apply(publisher);

        return new BookResource(id, title, isbnNumber, totalStock,
                availableStock, price, authorResources, publisherResource);
    }

}

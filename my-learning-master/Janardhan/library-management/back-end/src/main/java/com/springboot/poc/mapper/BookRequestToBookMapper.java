package com.springboot.poc.mapper;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.poc.model.Author;
import com.springboot.poc.model.Book;
import com.springboot.poc.model.Publisher;
import com.springboot.poc.request.AuthorRequest;
import com.springboot.poc.request.BookRequest;
import com.springboot.poc.request.PublisherRequest;
import com.springboot.poc.service.AuthorService;
import com.springboot.poc.service.PublisherService;

@Service
public class BookRequestToBookMapper implements Function<BookRequest, Book> {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private PublisherService publisherService;

    @Override
    public Book apply(BookRequest bookRequest) {

        Objects.requireNonNull(bookRequest);
        final String title = bookRequest.getTitle();

        Objects.requireNonNull(title);

        final String isbnNumber = bookRequest.getIsbnNumber();

        Objects.requireNonNull(isbnNumber);

        final Double price = bookRequest.getPrice();

        Objects.requireNonNull(price);

        final Long totalStock = bookRequest.getTotalStock() != null
                ? bookRequest.getTotalStock() : 0;

        final Long availableStock = bookRequest.getAvailableStock() != null
                ? bookRequest.getAvailableStock() : 0;

        final Set<AuthorRequest> authorRequests = bookRequest.getAuthors();
        final Set<Author> authors = new HashSet<>();
        for (AuthorRequest authorRequest : authorRequests) {
            Objects.requireNonNull(authorRequest);
            final Long authorRequestId = authorRequest.getId();
            Author author;
            author = authorService.getAuthorById(authorRequestId);
            authors.add(author);
        }

        PublisherRequest pubisherRequest = bookRequest.getPublisher();

        Objects.requireNonNull(pubisherRequest);

        Long publisherId = pubisherRequest.getId();
        String publisherName = pubisherRequest.getName();

        Objects.requireNonNull(publisherName);

        Publisher publisher;
        if (publisherId != null) {
            publisher = publisherService.getPublisherById(publisherId);
        } else {
            publisher = new Publisher(publisherName);
        }

        Book book = new Book(title, isbnNumber, totalStock, availableStock,
                price, publisher);
        book.setAuthors(authors);

        return book;
    }

}

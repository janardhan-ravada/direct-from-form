package com.springboot.poc.mapper;

import java.util.Objects;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.springboot.poc.model.Author;
import com.springboot.poc.request.AuthorRequest;

@Service
public class AuthorRequestToAuthorMapper
        implements Function<AuthorRequest, Author> {

    @Override
    public Author apply(final AuthorRequest authorRequest) {
        Objects.requireNonNull(authorRequest);

        final String name = authorRequest.getName();
        Objects.requireNonNull(name);

        final String emailAddress = authorRequest.getEmailAddress();

        return new Author(name, emailAddress);
    }

}

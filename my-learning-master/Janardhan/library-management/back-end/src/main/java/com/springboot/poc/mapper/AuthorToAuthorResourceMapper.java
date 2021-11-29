package com.springboot.poc.mapper;

import java.util.Objects;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.springboot.poc.model.Author;
import com.springboot.poc.resource.AuthorResource;

@Service
public class AuthorToAuthorResourceMapper
        implements Function<Author, AuthorResource> {

    @Override
    public AuthorResource apply(Author author) {

        Objects.requireNonNull(author);

        Long authorId = author.getId();
        Objects.requireNonNull(authorId);

        String authorName = author.getName();
        Objects.requireNonNull(authorName);

        String emailAddress = author.getEmailAddress();

        Objects.requireNonNull(emailAddress);

        AuthorResource authorResource = new AuthorResource(authorId, authorName,
                emailAddress);
        return authorResource;
    }

}

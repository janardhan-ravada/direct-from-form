package com.springboot.poc.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.poc.mapper.AuthorRequestToAuthorMapper;
import com.springboot.poc.mapper.AuthorToAuthorResourceMapper;
import com.springboot.poc.model.Author;
import com.springboot.poc.request.AuthorRequest;
import com.springboot.poc.resource.AuthorResource;
import com.springboot.poc.service.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorToAuthorResourceMapper authorToAuthorResourceMapper;

    @Autowired
    private AuthorRequestToAuthorMapper authorRequestToAuthorMapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<AuthorResource> getAllAuthors() {
        return authorService.getAllAuthors().stream()
                .map(authorToAuthorResourceMapper).collect(Collectors.toList());
    }

    /**
     * Adding Author
     * 
     * @param authorRequest
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addAuthor(@RequestBody AuthorRequest authorRequest) {
        Author author = authorRequestToAuthorMapper.apply(authorRequest);

        authorService.addAuthor(author);
    }
}

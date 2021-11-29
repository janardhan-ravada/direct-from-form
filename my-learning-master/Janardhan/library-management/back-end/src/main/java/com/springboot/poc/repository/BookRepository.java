package com.springboot.poc.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springboot.poc.model.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    public List<Book> findAll();

}

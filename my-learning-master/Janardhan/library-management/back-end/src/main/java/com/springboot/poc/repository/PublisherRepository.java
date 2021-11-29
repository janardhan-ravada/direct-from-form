package com.springboot.poc.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springboot.poc.model.Publisher;

@Repository
public interface PublisherRepository
        extends PagingAndSortingRepository<Publisher, Long> {

    List<Publisher> findAll();
}

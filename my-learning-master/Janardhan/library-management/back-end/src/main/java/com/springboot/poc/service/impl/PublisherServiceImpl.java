package com.springboot.poc.service.impl;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.poc.model.Publisher;
import com.springboot.poc.repository.PublisherRepository;
import com.springboot.poc.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    @Transactional
    public Publisher getPublisherById(Long id) {
        Objects.requireNonNull(id);

        return publisherRepository.findOne(id);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

}

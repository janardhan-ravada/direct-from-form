package com.springboot.poc.service;

import java.util.List;

import com.springboot.poc.model.Publisher;

public interface PublisherService {
    public Publisher getPublisherById(Long id);

    public List<Publisher> getAllPublishers();
}

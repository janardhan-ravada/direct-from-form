package com.springboot.poc.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.poc.mapper.PublisherToPublisherResourceMapper;
import com.springboot.poc.resource.PublisherResource;
import com.springboot.poc.service.PublisherService;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private PublisherToPublisherResourceMapper publisherToPublisherResourceMapper;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<PublisherResource> getAllPublishers() {
        return publisherService.getAllPublishers().stream()
                .map(publisherToPublisherResourceMapper)
                .collect(Collectors.toList());
    }
}

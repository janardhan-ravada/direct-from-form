package com.springboot.poc.mapper;

import java.util.Objects;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.springboot.poc.model.Publisher;
import com.springboot.poc.resource.PublisherResource;

@Service
public class PublisherToPublisherResourceMapper
        implements Function<Publisher, PublisherResource> {

    @Override
    public PublisherResource apply(Publisher publisher) {

        Objects.requireNonNull(publisher);

        Long publisherId = publisher.getId();
        Objects.requireNonNull(publisherId);

        String publisherName = publisher.getName();
        Objects.requireNonNull(publisherName);

        return new PublisherResource(publisherId, publisherName);
    }

}

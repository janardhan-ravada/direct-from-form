package com.springboot.poc.mapper;

import java.util.Objects;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.springboot.poc.model.Publisher;
import com.springboot.poc.request.PublisherRequest;

@Service
public class PublisherRequestToPublisherMapper
        implements Function<PublisherRequest, Publisher> {

    @Override
    public Publisher apply(final PublisherRequest publisherRequest) {

        Objects.requireNonNull(publisherRequest);

        String publisherName = publisherRequest.getName();
        Objects.requireNonNull(publisherName);

        Publisher publisher = new Publisher(publisherName);

        return publisher;
    }

}

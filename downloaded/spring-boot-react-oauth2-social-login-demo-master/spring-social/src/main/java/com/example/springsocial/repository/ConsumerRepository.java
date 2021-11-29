package com.example.springsocial.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.springsocial.model.Consumer;
import com.example.springsocial.model.User;

@Repository
public interface ConsumerRepository extends PagingAndSortingRepository<Consumer, Long> {
	
	Consumer findByUser(User user);

}

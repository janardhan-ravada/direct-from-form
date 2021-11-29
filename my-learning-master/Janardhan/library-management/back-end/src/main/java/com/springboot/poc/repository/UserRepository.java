package com.springboot.poc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springboot.poc.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByName(String name);
}

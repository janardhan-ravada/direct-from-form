package com.example.springsocial.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.springsocial.model.Farmer;
import com.example.springsocial.model.User;

@Repository
public interface FarmerRepository extends PagingAndSortingRepository<Farmer, Long> {

	Farmer findByUser(User user);

}

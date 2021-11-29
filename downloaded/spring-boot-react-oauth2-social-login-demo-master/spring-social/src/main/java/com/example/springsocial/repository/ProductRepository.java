package com.example.springsocial.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.springsocial.model.Farmer;
import com.example.springsocial.model.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	public List<Product> findAll();
	
	List<Product> findByFarmer(Farmer farmer);
}

package com.example.springsocial.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.springsocial.model.Address;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

}

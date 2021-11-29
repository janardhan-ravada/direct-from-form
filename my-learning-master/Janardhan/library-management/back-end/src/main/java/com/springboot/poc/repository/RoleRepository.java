package com.springboot.poc.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springboot.poc.model.Role;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

}

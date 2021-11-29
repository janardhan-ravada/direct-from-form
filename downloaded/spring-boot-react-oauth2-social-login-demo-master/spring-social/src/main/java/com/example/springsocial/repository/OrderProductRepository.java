package com.example.springsocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.springsocial.model.Farmer;
import com.example.springsocial.model.Order;
import com.example.springsocial.model.OrderProduct;

@Repository
public interface OrderProductRepository extends PagingAndSortingRepository<OrderProduct, Long> {
	List<OrderProduct> findByFarmer(Farmer farmer);

	@Query("SELECT distinct o.order from OrderProduct o where o.farmer=:farmer ")
	List<Order> findOrdersForFarmer(Farmer farmer);
}

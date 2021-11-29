package com.example.springsocial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsocial.model.Farmer;
import com.example.springsocial.model.Order;
import com.example.springsocial.model.Product;
import com.example.springsocial.payload.FarmerResponse;
import com.example.springsocial.payload.OrderResponse;
import com.example.springsocial.payload.ProductResponse;
import com.example.springsocial.repository.FarmerRepository;
import com.example.springsocial.repository.OrderProductRepository;
import com.example.springsocial.repository.ProductRepository;
import com.example.springsocial.repository.UserRepository;
import com.example.springsocial.security.UserPrincipal;

@RestController
public class FarmerController {

	@Autowired
	private FarmerRepository farmerRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderProductRepository orderProductRepository;

	@GetMapping("/farmer-inventory")
	public ResponseEntity<List<ProductResponse>> getFarmerInventory() {

		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		Farmer farmer = farmerRepository.findByUser(userRepository.findById(userPrincipal.getId()).get());

		List<Product> products = productRepository.findByFarmer(farmer);

		List<ProductResponse> farmerProducts = new ArrayList<>();

		products.forEach(product -> {
			farmerProducts.add(productToProductResponse(product));
		});
		return ResponseEntity.ok(farmerProducts);
	}

	@GetMapping("/farmer-orders")
	public ResponseEntity<List<OrderResponse>> getFarmerOrders() {
		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		Farmer farmer = farmerRepository.findByUser(userRepository.findById(userPrincipal.getId()).get());

		List<Order> orders = orderProductRepository.findOrdersForFarmer(farmer);
		List<OrderResponse> farmerOrders = new ArrayList<>();
		orders.forEach(order->farmerOrders.add(orderToOrderResponse(order)));
		return ResponseEntity.ok(farmerOrders);
	}

	private ProductResponse productToProductResponse(Product product) {
		ProductResponse productResponse = new ProductResponse();

		productResponse.setId(product.getId());
		productResponse.setName(product.getName());
		productResponse.setDesription(product.getDescription());
		productResponse.setTotalPacks(product.getTotalPacks());

		productResponse.setPackUnit(product.getPackUnit());
		productResponse.setPackPrice(product.getPackPrice());
		productResponse.setPackQuantity(product.getPackQuantity());
		productResponse.setDiscountOnPack(product.getDiscountOnPack());
		productResponse.setDiscountType("PERCENTAGE");
		productResponse.setImageURL(product.getImageURL());

		FarmerResponse farmer = new FarmerResponse();
		if (product.getFarmer() != null) {
			farmer.setName(product.getFarmer().getName());
		} else {
			farmer.setName("Janardhan");
		}

		productResponse.setFarmer(farmer);

		productResponse.setPackPriceWithDiscount(product.getPackPriceWithDiscount());
		productResponse.setTotalPacksPrice(product.getTotalPacksPrice());
		productResponse.setTotalPacksPriceWithDiscount(product.getTotalPacksPriceWithDiscount());
		productResponse.setDefaultRating(3.25);
		productResponse.setMaxRating(5.0);
		productResponse.setRemainingPacks(product.getRemainingPacks());
		return productResponse;
	}
	
	private OrderResponse orderToOrderResponse(Order order) {
		OrderResponse orderResponse = new OrderResponse();

		orderResponse.setId(order.getId());
		orderResponse.setTotalPrice(order.getTotalPrice());
		orderResponse.setTotalPriceWithDiscount(order.getTotalPriceWithDiscount());

		List<ProductResponse> products = new ArrayList<>();
		order.getOrderProducts().forEach((orderProduct) -> {

			ProductResponse pr = productToProductResponse(orderProduct.getProduct());
			pr.setOrderedQuantity(orderProduct.getOrderedQuantity());
			products.add(pr);
		});
		orderResponse.setStatus(order.getStatus());
		orderResponse.setProducts(products);
		orderResponse.setCreatedDate(order.getCreatedDate());
		return orderResponse;
	}
}

package com.example.springsocial.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springsocial.model.Address;
import com.example.springsocial.model.User;
import com.example.springsocial.payload.AddressRequest;
import com.example.springsocial.repository.AddressRepository;
import com.example.springsocial.repository.ConsumerRepository;
import com.example.springsocial.repository.FarmerRepository;
import com.example.springsocial.repository.UserRepository;
import com.example.springsocial.security.UserPrincipal;

@RestController
public class AddressController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ConsumerRepository consumerRepository;

	@Autowired
	private FarmerRepository farmerRepository;

	@PostMapping("/address")
	public ResponseEntity<?> addAddress( @RequestBody AddressRequest addressRequest) {
		UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();

		
		User user = userRepository.findById(userPrincipal.getId()).get();
		Address address = mapAddressRequestToAddress(addressRequest);
		if (user.getUserType().equals("CONSUMER")) {
			address.setConsumerId(consumerRepository.findByUser(user).getId());
		} else {
			address.setFarmerId(farmerRepository.findByUser(user).getId());
		}

		addressRepository.save(address);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/address/")
				.buildAndExpand(address.getId()).toUri();
		return ResponseEntity.created(location).body(address);
	}

	private Address mapAddressRequestToAddress(AddressRequest addressRequest) {
		Address address = new Address();
		address.setHouseNumber(addressRequest.getHouseNumber());
		address.setRoad(addressRequest.getRoadNumber());
		address.setStreet(addressRequest.getStreet());
		address.setArea(addressRequest.getArea());
		address.setMandal(addressRequest.getMandal());
		address.setDistrict(addressRequest.getDistrict());
		address.setState(addressRequest.getState());
		address.setPinCode(addressRequest.getPincode());
		address.setLandMark(addressRequest.getLandMark());
		address.setPhoneNumber(addressRequest.getPhoneNumber());
		address.setAlternativeNumber(addressRequest.getAlternatePhoneNumber());

		return address;
	}
}

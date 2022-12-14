package com.nissan.service;

import java.util.List;

import com.nissan.entity.Customer;

public interface ICustomerService {

	Customer getCustomerById(Integer customerId);
	
	List<Customer> getAllCustomers();
	
}

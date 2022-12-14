package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.entity.Customer;
import com.nissan.repository.CustomerDao;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer getCustomerById(Integer customerId) {
		return customerDao.findById(customerId).orElse(null);
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = customerDao.findAll();
		
		if(customerList.isEmpty()) {
			return null;
		} else {
			return customerList;
		}
	}

}

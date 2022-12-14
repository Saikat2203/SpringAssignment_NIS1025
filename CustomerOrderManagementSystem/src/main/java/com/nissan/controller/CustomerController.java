package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.entity.Customer;
import com.nissan.entity.Order;
import com.nissan.entity.OrderItem;
import com.nissan.service.ICustomerService;
import com.nissan.service.IOrderItemService;
import com.nissan.service.IOrderService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService; 
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderItemService orderItemService;
	
	@GetMapping
	public ResponseEntity<?> getAllCustomers() {
		List<Customer> customerList = customerService.getAllCustomers();
		
		if(customerList == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Database is empty!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(customerList);
		}
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<?> getOrderDetails(@PathVariable int id) {
		Customer customer = customerService.getCustomerById(id);
		
		if(customer == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found!!!");
		} else {
			List<Order> orderList = orderService.getAllOrdersByCustNo(id);
			
			if(orderList.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer has not placed any order!!!");
			} else {
				List<OrderItem> orderItemList = orderItemService.getOrderListByCustNo(id);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(orderItemList);
			}
		}
	}
	
}

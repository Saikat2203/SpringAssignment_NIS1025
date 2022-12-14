package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.entity.Customer;
import com.nissan.entity.Order;
import com.nissan.repository.CustomerDao;
import com.nissan.repository.OrderDao;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Order getOrderById(Integer orderId) {
		return orderDao.findById(orderId).orElse(null);
	}

	@Override
	public List<Order> getAllOrdersByCustNo(Integer custNo) {
		Customer customer = customerDao.findById(custNo).orElse(null);
		
		if(customer == null) {
			return null;
		} else {
			return orderDao.findByCustNo(custNo);
		}
	}

}

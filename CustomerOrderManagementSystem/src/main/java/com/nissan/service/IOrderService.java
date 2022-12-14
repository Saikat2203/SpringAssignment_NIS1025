package com.nissan.service;

import java.util.List;

import com.nissan.entity.Order;

public interface IOrderService {

	Order getOrderById(Integer orderId);
	
	List<Order> getAllOrdersByCustNo(Integer custNo);
}

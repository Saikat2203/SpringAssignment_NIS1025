package com.nissan.service;

import java.util.List;

import com.nissan.entity.OrderItem;

public interface IOrderItemService {

	OrderItem getOrderItemById(Integer orderItemId);
	
	List<OrderItem> getOrderListByCustNo(Integer custNo);
	
}

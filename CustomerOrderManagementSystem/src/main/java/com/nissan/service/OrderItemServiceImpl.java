package com.nissan.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.entity.Customer;
import com.nissan.entity.Order;
import com.nissan.entity.OrderItem;
import com.nissan.repository.CustomerDao;
import com.nissan.repository.OrderDao;
import com.nissan.repository.OrderItemDao;

@Service
@Transactional
public class OrderItemServiceImpl implements IOrderItemService {

	@Autowired
	private OrderItemDao orderItemDao;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private OrderDao orderDao;

	@Override
	public OrderItem getOrderItemById(Integer orderItemId) {
		// TODO Auto-generated method stub
		return orderItemDao.findById(orderItemId).orElse(null);
	}

	@Override
	public List<OrderItem> getOrderListByCustNo(Integer custNo) {
		Customer customer = customerDao.findById(custNo).orElse(null);

		if (customer == null) {
			return null;
		} else {
			List<Order> orderList = orderDao.findByCustNo(custNo);
			List<OrderItem> resultList = new ArrayList<>();
			for (Order order : orderList) {
				List<OrderItem> orderItemList = orderItemDao.findByOrderNo(order.getOrderNo());
				for (OrderItem orderItem : orderItemList) {
					resultList.add(orderItem);
				}
			}
			return resultList;
		}
	}

}

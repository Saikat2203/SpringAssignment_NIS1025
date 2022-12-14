package com.nissan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.entity.OrderItem;

@Repository
public interface OrderItemDao extends JpaRepositoryImplementation<OrderItem, Integer> {
	
	List<OrderItem> findByOrderNo(Integer orderNo);
}

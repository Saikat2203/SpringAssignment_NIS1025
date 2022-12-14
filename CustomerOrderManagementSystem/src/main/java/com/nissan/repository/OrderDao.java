package com.nissan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Order;

@Repository
public interface OrderDao extends JpaRepositoryImplementation<Order, Integer> {

	List<Order> findByCustNo(Integer custNo);
	
}

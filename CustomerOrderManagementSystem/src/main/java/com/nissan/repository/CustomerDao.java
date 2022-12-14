package com.nissan.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepositoryImplementation<Customer, Integer>{
	
}

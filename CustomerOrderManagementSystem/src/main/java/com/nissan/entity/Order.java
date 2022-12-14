package com.nissan.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tblOrder")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer orderNo;
	
	private Integer custNo;
	
	@ManyToOne
	@JoinColumn(name = "custNo", insertable = false, updatable = false)
	private Customer customer;
	
	@Setter(AccessLevel.NONE)
	private LocalDate orderDate;

	public Order(Integer custNo) {
		this.custNo = custNo;
		orderDate = LocalDate.now();
	}
	
}

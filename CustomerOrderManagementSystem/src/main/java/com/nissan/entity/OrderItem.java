package com.nissan.entity;

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
@Table(name = "tblOrderItem")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer itemId;
	
	private Integer orderNo;
	
	@ManyToOne
	@JoinColumn(name = "orderNo", insertable = false, updatable = false)
	private Order order;
	
	private String itemName;
	
	private Integer quantity;

	public OrderItem(Integer orderNo, String itemName, Integer quantity) {
		this.orderNo = orderNo;
		this.itemName = itemName;
		this.quantity = quantity;
	}
	
}

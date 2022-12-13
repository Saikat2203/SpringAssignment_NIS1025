package com.nissan.entity;

import org.springframework.stereotype.Component;

@Component
public class Ford implements IVehicle {

	@Override
	public String displayTopSpeed() {
		// TODO Auto-generated method stub
		return "Ford with top speed 200kmph";
	}

}

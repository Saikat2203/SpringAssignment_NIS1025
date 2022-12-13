package com.nissan.entity;

import org.springframework.stereotype.Component;

@Component
public class Audi implements IVehicle {

	@Override
	public String displayTopSpeed() {
		// TODO Auto-generated method stub
		return "Nissan with top speed 320kmph";
	}

}

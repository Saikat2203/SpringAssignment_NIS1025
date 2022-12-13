package com.nissan.entity;

import org.springframework.stereotype.Component;

@Component
public class Tata implements IVehicle {

	@Override
	public String displayTopSpeed() {
		return "Tata with top speed 180kmph";
	}

}

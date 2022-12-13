package com.nissan.entity;

import org.springframework.stereotype.Component;

@Component
public class Nissan implements IVehicle {

	@Override
	public String displayTopSpeed() {
		return "Nissan with top speed 220kmph";
	}

}

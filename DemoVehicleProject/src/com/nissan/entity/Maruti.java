package com.nissan.entity;

import org.springframework.stereotype.Component;

@Component
public class Maruti implements IVehicle {

	@Override
	public String displayTopSpeed() {
		// TODO Auto-generated method stub
		return "Maruti with top speed 150kmph";
	}

}

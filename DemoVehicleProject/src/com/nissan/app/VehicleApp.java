package com.nissan.app;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nissan.entity.IVehicle;

public class VehicleApp {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			IVehicle audiVehicle = context.getBean("audi", IVehicle.class);
			System.out.println(audiVehicle.displayTopSpeed());
			IVehicle tataVehicle = context.getBean("tata", IVehicle.class);
			System.out.println(tataVehicle.displayTopSpeed());
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

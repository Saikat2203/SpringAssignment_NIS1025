package com.nissan.entity;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.nissan.service.IFortuneService;

@Component
public class Fortune implements IFortuneService {

	@Override
	public String getFortune() {
		String[] fortuneArr = {"10000000", "80", "80000"};
		Random rand = new Random();
        int randomnumber = rand.nextInt(3);
        return fortuneArr[randomnumber];
	}

}

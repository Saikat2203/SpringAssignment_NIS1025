package com.nissan.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nissan.service.IFortuneService;

public class FortuneApp {

	public static void main(String[] args) {
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
			IFortuneService fortune = context.getBean("fortune", IFortuneService.class);
			System.out.println(fortune.getFortune());
		}
	}

}

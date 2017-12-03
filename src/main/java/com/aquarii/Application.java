package com.aquarii;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aquarii.config.AppConfig;
import com.aquarii.service.CustomerService;

public class Application {

	public static void main(String[] args) {

	//All Bean Creation
	ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	CustomerService customerService = appContext.getBean("customerService1",CustomerService.class);
	
	System.out.println(customerService);
	
	CustomerService customerService2 = appContext.getBean("customerService1",CustomerService.class);
	
	System.out.println(customerService2);
	
	System.out.println(customerService.findAll().get(0).toString());
	
	
	
	}

}

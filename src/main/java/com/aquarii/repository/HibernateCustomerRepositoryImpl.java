package com.aquarii.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;

import com.aquarii.model.Customer;


//@Component("CustomerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {
	
	@Value("${giveValue}")
	private String giveValue;
	
	@Override
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<>();
		
		Customer customer = new Customer();
		customer.setFirstName(giveValue);
		customer.setLastName("Suwal");
		
		customers.add(customer);
		return customers;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("----------------------Initializing HibernateCustomerRepositoryImpl Bean");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("----------------------Destroying HibernateCustomerRepositoryImpl Bean");
	}

}

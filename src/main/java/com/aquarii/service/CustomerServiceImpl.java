package com.aquarii.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.aquarii.model.Customer;
import com.aquarii.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {
	
	//@Autowired  //Enable this if you are not Injecting from JavaConfig
	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl() {
	}

	//this method inject Instance of customerRepository
	//@Autowired //Enable this if you are not Injecting from JavaConfig
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("CustomerServiceImpl:: Injecting from SetterMethod");
		this.customerRepository = customerRepository;
	}
	
	
	//this constructor inject Instance of customerRepository
	//@Autowired  //Enable this if you are not Injecting from JavaConfig
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		System.out.println("CustomerServiceImpl:: Injecting from Parameterized Constructor::"+customerRepository);
		this.customerRepository = customerRepository;
	}



	@Override
	public List<Customer> findAll(){
		return this.customerRepository.findAll();
	}
	
	
	@PostConstruct
	public void init() {
		System.out.println("----------------------Initializing CustomerServiceImpl Bean");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("----------------------Destroying CustomerServiceImpl Bean");
	}
}

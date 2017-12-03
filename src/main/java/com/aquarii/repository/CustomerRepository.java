package com.aquarii.repository;

import java.util.List;

import com.aquarii.model.Customer;

public interface CustomerRepository {

	public List<Customer> findAll();

}
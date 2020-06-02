package com.nitinshirale.sprin.dao;

import java.util.List;

import com.nitinshirale.spring.entity.Customer;

public interface Customer_DAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getcustomer(int theId);

	public void deleteCustomer(int theId);

	//public void saveCustomer(Customer theCustomer);

	//public void saveCustomer(Customer theCustomer);
}

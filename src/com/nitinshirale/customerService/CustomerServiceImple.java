package com.nitinshirale.customerService;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nitinshirale.sprin.dao.Customer_DAO;
import com.nitinshirale.spring.entity.Customer;
@Service
public class CustomerServiceImple implements CustomerService {
	
	//need to inject customer dao
@Autowired
private Customer_DAO Customersdao;
	@Override
	@Transactional
	   public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return Customersdao.getCustomers();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		Customersdao.saveCustomer(theCustomer);
	}
	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		// TODO Auto-generated method stub
		return Customersdao.getcustomer(theId);
	}
	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		Customersdao.deleteCustomer(theId);
		
	}
		
	

}

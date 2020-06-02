package com.nitinshirale.sprin.dao;

import java.util.List;

//import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.nitinshirale.spring.entity.Customer;

@Repository
public class CustomerImple implements Customer_DAO {

	// need to inject the session factory
		@Autowired
		private SessionFactory sessionFactory;
				
		@Override
		//@Transactional
		public List<Customer> getCustomers() {
			
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
					
			// create a query
			Query<Customer> theQuery = 
					currentSession.createQuery("from Customer", Customer.class);
			
			// execute query and get result list
			List<Customer> customers = theQuery.getResultList();
					
			// return the results		
			return customers;
		}
		@Override
		public void saveCustomer(Customer theCustomer) {

			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// save the customer ... finally LOL
			currentSession.saveOrUpdate(theCustomer);
			
		}
		@Override
		public Customer getcustomer(int theId) {
			// 
			Session currentSession = sessionFactory.getCurrentSession();

			// now retrieve/read from database using the primary key
			Customer theCustomer = currentSession.get(Customer.class, theId);
			
			return theCustomer;
			
		}
		@Override
		public void deleteCustomer(int theId) {
			Session currentSession = sessionFactory.getCurrentSession();
			//delete obj with primary key
			Query thequery=currentSession.createQuery("delete from Customer where id=:customerId");
			thequery.setParameter("customerId",theId);
			thequery.executeUpdate();
		}
	}








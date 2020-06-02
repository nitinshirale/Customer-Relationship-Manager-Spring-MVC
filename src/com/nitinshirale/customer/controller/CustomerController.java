package com.nitinshirale.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nitinshirale.customerService.CustomerService;
import com.nitinshirale.sprin.dao.Customer_DAO;
import com.nitinshirale.spring.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
	///web_customer_tracker/src/com/nitinshirale/sprin/dao/CustomerImple.java
	//@Autowired
	//private Customer_DAO customerdao;
	@Autowired 
	private CustomerService customerService;
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
	
		// get customers from the dao/Service
		
		List <Customer> thecustomer=customerService.getCustomers();
		
		// add the customers to the model
				theModel.addAttribute("customers", thecustomer);
		return "list-customers";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);
		
		
		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	
	public String showFormForUpdate (@RequestParam("customerId") int theId, Model theModel){
		// get the customer from our service
		

		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form		
		return "customer-form";
	}
	@GetMapping("/delete")
	
	public String deleteForm (@RequestParam("customerId") int theId){

		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
}

}

	
	



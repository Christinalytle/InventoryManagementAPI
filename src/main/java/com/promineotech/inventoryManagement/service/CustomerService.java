package com.promineotech.inventoryManagement.service;

import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.inventoryManagement.entity.Customer;
import com.promineotech.inventoryManagement.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private static final Logger Logger = LogManager.getLogger(CustomerService.class); 
	
	@Autowired
	private CustomerRepository repo; 
	
	public Customer getCustomerById(Long id) {
		Logger.info("Retreiving customer by ID ={}", id); 
		Customer customer = repo.findById(id).orElseThrow(); 
		
		if (customer == null) {
			throw new NoSuchElementException("Customer with ID=" + id + " is not found.");
		}
		
		return customer; 
	}

	public Iterable<Customer> getCustomers() {
		return repo.findAll(); 
	}
	
	public Customer createCustomer (Customer customer) {
		return repo.save(customer); 
	}
	
	public Customer updateCustomer (Customer customer, Long id) throws Exception {
		try {
			Customer oldCustomer = repo.findById(id).orElseThrow(); 
			oldCustomer.setAddress(customer.getAddress());
			oldCustomer.setFirstName(customer.getFirstName());
			oldCustomer.setLastName(customer.getLastName());
			oldCustomer.setLevel(customer.getLevel()); 
			return repo.save(oldCustomer); 
		} catch (Exception e) {
			Logger.error("Exception occured while trying to update customer: " + id, e);
			throw new Exception("Unable to update customer."); 
		}
	}
	
	public void deleteCustomer(Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			Logger.error("Exception occurred while trying to delete customer: " + id, e);
			throw new Exception("Unable to delete customer.");
		}
	}
}

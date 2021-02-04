package com.promineotech.inventoryManagement.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.promineotech.inventoryManagement.util.OrderStatus;

@Entity
public class Orders {
	
	private Long id; 
	private LocalDate ordered; 
	private LocalDate estimatedDeilvery; 
	private LocalDate delivered; 
	private double invoiceAmount; 
	private OrderStatus status; 
	private Set<Product> products;
	
	@JsonIgnore
	private Customer customer; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getOrdered() {
		return ordered;
	}
	public void setOrdered(LocalDate ordered) {
		this.ordered = ordered;
	}
	public LocalDate getEstimatedDeilvery() {
		return estimatedDeilvery;
	}
	public void setEstimatedDeilvery(LocalDate estimatedDeilvery) {
		this.estimatedDeilvery = estimatedDeilvery;
	}
	public LocalDate getDelivered() {
		return delivered;
	}
	public void setDelivered(LocalDate delivered) {
		this.delivered = delivered;
	}
	public double getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	@ManyToMany(mappedBy = "orders")
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	} 

}


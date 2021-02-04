package com.promineotech.inventoryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.inventoryManagement.entity.Orders;

public interface OrderRepository extends JpaRepository <Orders, Long> {

}

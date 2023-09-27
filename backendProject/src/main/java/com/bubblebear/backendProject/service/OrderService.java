package com.bubblebear.backendProject.service;

import java.util.List;

import com.bubblebear.backendProject.entity.Orders;

public interface OrderService {
	
	Orders createOrder(Orders order);
	
	Orders getOrderById(int id);
	
	List<Orders> getAllOrders();
	
	Orders updateOrder(Orders order, int id);
	
	void deleteOrder(int id);
	
	
	
}

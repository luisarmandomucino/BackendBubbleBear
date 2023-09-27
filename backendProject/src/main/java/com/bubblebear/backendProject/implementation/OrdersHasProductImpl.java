package com.bubblebear.backendProject.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubblebear.backendProject.entity.OrdersHasProducts;
import com.bubblebear.backendProject.repository.OrdersHasProductsRepository;
import com.bubblebear.backendProject.service.OrdersHasProductService;

@Service
public class OrdersHasProductImpl implements OrdersHasProductService{
	@Autowired
	OrdersHasProductsRepository ordersHasProductsRepository;

	@Override
	public OrdersHasProducts createOrderHasProduct(OrdersHasProducts orderProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersHasProducts getOrderHasProductById(long orderId, long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersHasProducts updateOrderHasProduct(OrdersHasProducts orderProduct, long orderId, long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrderHasProduct(long orderId, long productId) {
		// TODO Auto-generated method stub
		
	}
	
	

}

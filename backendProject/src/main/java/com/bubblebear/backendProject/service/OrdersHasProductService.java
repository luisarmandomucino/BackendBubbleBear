package com.bubblebear.backendProject.service;

import com.bubblebear.backendProject.entity.OrdersHasProducts;

public interface OrdersHasProductService {
	
	OrdersHasProducts createOrderHasProduct(OrdersHasProducts orderProduct);
	
	OrdersHasProducts getOrderHasProductById(long orderId, long productId);	
	
	OrdersHasProducts updateOrderHasProduct(OrdersHasProducts orderProduct, long orderId, long productId);
	
	void deleteOrderHasProduct(long orderId, long productId);

}

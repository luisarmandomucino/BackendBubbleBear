package com.bubblebear.backendProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bubblebear.backendProject.entity.Orders;
import com.bubblebear.backendProject.repository.OrdersRepository;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("api/orders")
@Log4j2



public class OdersController {
	
	
	@Autowired
	OrdersRepository ordersRepository;
	
	
	@GetMapping
	public List<Orders> getAllOrders() {
		List<Orders> orders = (List<Orders>) ordersRepository.findAll();
		return orders;
	}
	
	@GetMapping("{id}") //localhosts:8080/api/orders/#
	public Orders getOrderById(@PathVariable int id){
		Orders order = ordersRepository.findById(id);
		return order;
		
	}
	
	@PutMapping("{id}") //localhosts:8080/api/orders/#
	public Orders updateOrder(@RequestBody Orders order, @PathVariable int id) {
		Orders existingOrder = ordersRepository.findById(id);
		
		if(existingOrder == null) {
			throw new IllegalStateException("Order not found");
		}
		existingOrder.setOrder_id( order.getOrder_id() );
		existingOrder.setTotal_amount( order.getTotal_amount() );
		existingOrder.setPurchase_date( order.getPurchase_date() );
		existingOrder.setFk_user_id( order.getFk_user_id() );
		return ordersRepository.save( existingOrder );	
		
	}
	
	@PostMapping
	public Orders insertOrder(@RequestBody Orders order) {
		order.setOrder_id(null);
		
		
		
		Orders newOrder = ordersRepository.save(order);
		return newOrder;	
		
	}
	
	@DeleteMapping("{id}")
	public void deleteOrder(@PathVariable int id) {
		Orders findOrder = ordersRepository.findById(id);
		ordersRepository.delete(findOrder);
	}

}

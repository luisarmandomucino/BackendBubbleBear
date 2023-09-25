package com.bubblebear.backendProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bubblebear.backendProject.entity.OrdersHasProducts;
import com.bubblebear.backendProject.repository.OrdersHasProductsRepository;

@RestController
@RequestMapping("api/ordershasproducts")
public class OrdersHasProductsController {

    @Autowired
    OrdersHasProductsRepository ordersHasProductsRepository;

    @GetMapping
    public List<OrdersHasProducts> getAllOrdersHasProducts() {
        return (List<OrdersHasProducts>) ordersHasProductsRepository.findAll();
    }

    @GetMapping("{id}")
    public OrdersHasProducts getOrdersHasProductsById(@PathVariable long id) {
        OrdersHasProducts entry = ordersHasProductsRepository.findById(id);
        return entry;
    }


    @PostMapping
    public OrdersHasProducts createOrdersHasProducts(@RequestBody OrdersHasProducts newEntry) {
        return ordersHasProductsRepository.save(newEntry);
    }

    @PutMapping("{id}")
    public OrdersHasProducts updateOrdersHasProducts(@PathVariable long id, @RequestBody OrdersHasProducts updatedEntry) {
        OrdersHasProducts existingOrder = ordersHasProductsRepository.findById(id);
        existingOrder.setOrder(updatedEntry.getOrder());
		return ordersHasProductsRepository.save(existingOrder);
    }

    @DeleteMapping("{id}")
    public void deleteOrdersHasProducts(@PathVariable long id) {
        ordersHasProductsRepository.deleteById(id);
    }
} 

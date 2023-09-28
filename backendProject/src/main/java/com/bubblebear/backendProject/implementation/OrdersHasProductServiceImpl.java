package com.bubblebear.backendProject.implementation;

import com.bubblebear.backendProject.entity.OrdersHasProducts;
import com.bubblebear.backendProject.repository.OrdersHasProductsRepository;
import com.bubblebear.backendProject.service.OrdersHasProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersHasProductServiceImpl implements OrdersHasProductService {

    private final OrdersHasProductsRepository ordersHasProductsRepository;

    @Autowired
    public OrdersHasProductServiceImpl(OrdersHasProductsRepository ordersHasProductsRepository) {
        this.ordersHasProductsRepository = ordersHasProductsRepository;
    }

    @Override
    public OrdersHasProducts createOrderHasProduct(OrdersHasProducts orderProduct) {
        return ordersHasProductsRepository.save(orderProduct);
    }

    @Override
    public OrdersHasProducts getOrderHasProductById(long orderId, long productId) {
        return ordersHasProductsRepository.findById(orderId);
    }

    @Override
    public OrdersHasProducts updateOrderHasProduct(OrdersHasProducts orderProduct, long orderId, long productId) {
        OrdersHasProducts existingOrderProduct = ordersHasProductsRepository.findById(orderId);
        if (existingOrderProduct != null) {
            // Actualiza los campos según sea necesario
            existingOrderProduct.setQuantity(orderProduct.getQuantity());
            existingOrderProduct.setPriceProduct(orderProduct.getPriceProduct());
            // Guarda la actualización
            return ordersHasProductsRepository.save(existingOrderProduct);
        }
        return null; // Puedes manejar el caso de que no se encuentre la relación de otra manera
    }

    @Override
    public void deleteOrderHasProduct(long orderId, long productId) {
        ordersHasProductsRepository.deleteById(orderId);
    }
}

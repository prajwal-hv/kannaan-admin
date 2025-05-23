package com.kannaan.admin.service;

import com.kannaan.admin.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getAllOrders();
    Optional<Order> getOrderById(String id);
    Order updateOrder(String id, Order updatedOrder);
    void deleteOrder(String id);
}

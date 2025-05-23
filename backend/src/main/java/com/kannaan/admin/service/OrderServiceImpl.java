package com.kannaan.admin.service;

import com.kannaan.admin.model.Order;
import com.kannaan.admin.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }


    @Override
    public Order createOrder(Order order) {
        if(order.getOrderDate()==null){
            order.setOrderDate(LocalDateTime.now());
        }
        if(order.getStatus()==null){
            order.setStatus("Pending");
        }

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrder(String id, Order updatedOrder) {
        return orderRepository.findById(id).map(existingOder->{
            existingOder.setCustomerName(updatedOrder.getCustomerName());
            existingOder.setProductIds(updatedOrder.getProductIds());
            existingOder.setQuantity(updatedOrder.getQuantity());
            existingOder.setStatus(updatedOrder.getStatus());
            return orderRepository.save(existingOder);
        }).orElseThrow(()->new RuntimeException("Order not found with id::"+id));
    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}

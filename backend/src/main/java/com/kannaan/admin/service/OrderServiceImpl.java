package com.kannaan.admin.service;

import com.kannaan.admin.model.Order;
import com.kannaan.admin.model.OrderItem;
import com.kannaan.admin.model.Product;
import com.kannaan.admin.repository.OrderRepository;
import com.kannaan.admin.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    @Override
    public Order createOrder(Order order) {



        if (order.getStatus() == null) {
            order.setStatus("Pending");
        }


        order.setTotalPrice(calculateTotalPrice(order.getItems()));

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
//        System.out.println("Debug:: Update Order Request::" + updatedOrder.getItems().toString());
        return orderRepository.findById(id).map(existingOder -> {
            if (updatedOrder.getCustomerName() != null) existingOder.setCustomerName(updatedOrder.getCustomerName());
            if (updatedOrder.getItems() != null) {
                existingOder.setItems(updatedOrder.getItems());
                existingOder.setTotalPrice(calculateTotalPrice(updatedOrder.getItems()));
            }
            if (!updatedOrder.getStatus().isEmpty()) existingOder.setStatus(updatedOrder.getStatus());
            return orderRepository.save(existingOder);
        }).orElseThrow(() -> new RuntimeException("Order not found with id::" + id));
    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }

    private double calculateTotalPrice(List<OrderItem> items) {
        double total = 0;
        for (OrderItem item : items) {
            Product product = productRepository.findById(item.getProductId()).orElseThrow(() -> new RuntimeException("Product Not Found:: " + item.getProductId()));
            total += product.getPrice() * item.getQuantity();
        }
        return total;
    }
}

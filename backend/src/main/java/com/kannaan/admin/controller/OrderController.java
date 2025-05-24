package com.kannaan.admin.controller;

import java.util.List;

import com.kannaan.admin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kannaan.admin.model.Order;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order){
        System.out.println(order);
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable String id, @RequestBody Order updatedOrder) {
        try{
            return ResponseEntity.ok(orderService.updateOrder(id, updatedOrder));
        }catch (RuntimeException e){
            System.out.println("Unable to process the request::"+ e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOder(@PathVariable String id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}

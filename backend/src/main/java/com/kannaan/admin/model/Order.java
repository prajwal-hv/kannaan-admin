package com.kannaan.admin.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private String customerName;
    private String productType;
    private String productId;
    private int quantity;
    private String status;
    private LocalDateTime orderDate;


    // Constuctor
    public Order(){
        this.orderDate = LocalDateTime.now();
        this.status = "Pending";
    }
    
}

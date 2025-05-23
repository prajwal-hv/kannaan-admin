package com.kannaan.admin.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String name;
    private String category;
    private Double price;
    private String description;

    public Product() {

    }

    public Product(String name, String category, Double price, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }
}

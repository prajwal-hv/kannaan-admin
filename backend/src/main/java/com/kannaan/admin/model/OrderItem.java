package com.kannaan.admin.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private String productId;
    private int quantity;
}

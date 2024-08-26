package org.sid.order_service.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private double price;
    private int qte;
    private String description;
}
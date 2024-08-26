package org.sid.order_service.model;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String firstName;
    private String email;
}
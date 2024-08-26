package org.sid.customer_service.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer",types = Customer.class)
public interface CustomerProjection {
    public Long getId();
    public String getFirstName();
    public String getEmail();
}
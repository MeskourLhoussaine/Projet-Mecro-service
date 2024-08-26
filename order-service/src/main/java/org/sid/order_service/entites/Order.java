package org.sid.order_service.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.order_service.enums.OrderStatus;
import org.sid.order_service.model.Customer;

import java.util.Date;
import java.util.List;
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date order_date;
    private OrderStatus status;
    private Long customerId;
    @Transient /* demande a jpa de ne pas prendre en consederation */
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;

}

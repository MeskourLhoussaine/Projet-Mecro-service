package org.sid.order_service.web;

import lombok.AllArgsConstructor;
import org.sid.order_service.entites.Order;
import org.sid.order_service.model.Customer;
import org.sid.order_service.model.Product;
import org.sid.order_service.repository.OrderRepository;
import org.sid.order_service.repository.ProductItemRepository;
import org.sid.order_service.services.CustomerRestClientService;
import org.sid.order_service.services.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderRestController {
    private final CustomerRestClientService customerRestClientService;
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService productRestClientService;
    private InventoryRestClientService inventoryRestClientService;
    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order =orderRepository.findById(id).get();

Customer customer = customerRestClientService.customerById(order.getCustomerId());
order.setCustomer(customer);
order.getProductItems().forEach(pi ->{
    Product product = inventoryRestClientService.productById(pi.getProductId());
    pi.setProduct(product);
} );
return order;
    }
}

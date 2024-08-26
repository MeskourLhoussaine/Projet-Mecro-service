package org.sid.inventory_service.repository;

import org.sid.inventory_service.entites.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//Spring Data REST génère automatiquement les endpoints pour votre repository
//exemple, pour ProductRepository, vous aurez un endpoint /products qui gère toutes les opérations CRUD
@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Long> {
}

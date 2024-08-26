package org.sid.inventory_service;

import org.sid.inventory_service.entites.Product;
import org.sid.inventory_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {

			Random random=new Random();
			for (int i = 1; i <10 ; i++) {
				productRepository.saveAll(List.of(
						Product.builder()
								.name("Compuer "+i)
								.price(1200+Math.random()*10000)
								.qte(1+random.nextInt(200)).description("produi"+i)
								.build()
				));
			}

		};
	}
}

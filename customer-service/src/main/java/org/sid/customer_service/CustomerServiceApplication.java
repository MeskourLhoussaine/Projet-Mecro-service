package org.sid.customer_service;

import org.sid.customer_service.entities.Customer;
import org.sid.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootApplication

public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}
@Bean
CommandLineRunner start(CustomerRepository repository) {
		return args -> {
			repository.saveAll(List.of(
					Customer.builder().firstName("meskour").email("mesk@gmail.com").build(),
					Customer.builder().firstName("lhoussaine").email("louis@gmail.com").build(),
					Customer.builder().firstName("anas").email("anas@gmail.com").build()
			));
			repository.findAll().forEach(System.out::println);
		};
}
}

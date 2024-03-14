package com.example.accessingdatajpa;

import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerRepository, StuffRepository stuffRepository) {
		return (args) -> {
			// save a few customers and stuffs
			Customer jack = new Customer("Jack", "Bauer");
			Customer chloe = new Customer("Chloe", "O'Brian");
			Customer kim = new Customer("Kim", "Bauer");
			customerRepository.save(new Customer("David", "Palmer"));
			customerRepository.save(new Customer("Michelle", "Dessler"));
			Stuff thing = new Stuff("thing");
			Stuff object = new Stuff("object");
			stuffRepository.save(thing);
			stuffRepository.save(object);
			jack.setStuffs(Arrays.asList(thing, object));
			chloe.setStuffs(Arrays.asList(thing));
			kim.setStuffs(Arrays.asList(object));
			customerRepository.save(jack);
			customerRepository.save(chloe);
			customerRepository.save(kim);

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			customerRepository.findAll().forEach(customer -> {
				log.info(customer.toString());
			});
			log.info("");

			// fetch an individual customer by ID
			Customer customer = customerRepository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			customerRepository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			log.info("");
		};
	}

}

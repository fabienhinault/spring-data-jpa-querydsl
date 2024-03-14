package com.example.accessingdatajpa;

import java.util.List;
import java.util.stream.Collectors;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;

	// default table name: customer_stuffs
	@ManyToMany
	List<Stuff> stuffs;

	protected Customer() {}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, firstName='%s', lastName='%s']",
				id, firstName, lastName);
				// + stuffs.stream().map(Stuff::getName).collect(Collectors.joining(", "));
				// IllegalStateException: ApplicationContext failure threshold (1) exceeded
				// LazyInitializationException: failed to lazily initialize a collection of role: com.example.accessingdatajpa.Customer.stuffs
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<Stuff> getStuffs() {
		return stuffs;
	}

	public void setStuffs(List<Stuff> stuffs) {
		this.stuffs = stuffs;
	}
}

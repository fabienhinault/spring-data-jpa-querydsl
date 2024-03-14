package com.example.accessingdatajpa;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Stuff {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    
	private String name;

    @ManyToMany
    List<Customer> customers;

    public Stuff(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

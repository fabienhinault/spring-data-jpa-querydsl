package com.example.accessingdatajpa;

import java.util.List;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long>, QuerydslPredicateExecutor<Customer> {

	List<Customer> findByLastName(String lastName);

	Customer findById(long id);
}

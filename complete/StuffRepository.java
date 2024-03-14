package com.example.accessingdatajpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface StuffRepository  extends CrudRepository<Stuff, Long>, QuerydslPredicateExecutor<Stuff> {
    
	List<Stuff> findByName(String name);

}

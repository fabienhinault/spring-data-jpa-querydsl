package com.example.accessingdatajpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StuffRepository  extends CrudRepository<Stuff, Long> {
    
	List<Stuff> findByName(String name);

	List<Stuff> findByCustomersLastName(String customerLastName);

}

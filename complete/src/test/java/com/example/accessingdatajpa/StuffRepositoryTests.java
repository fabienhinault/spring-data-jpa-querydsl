/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.accessingdatajpa;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class StuffRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private StuffRepository stuffRepository;

	@Test
	public void testFindByName() {
		Stuff stuff = new Stuff("stuffName");
		entityManager.persist(stuff);

		List<Stuff> findByLastName = stuffRepository.findByName(stuff.getName());

		assertThat(findByLastName).extracting(Stuff::getName).containsOnly(stuff.getName());
	}


	@Test
	public void testFindByCustomerName() {
		Stuff stuff1 = new Stuff("stuff1");
		entityManager.persist(stuff1);
		Stuff stuff2 = new Stuff("stuff2");
		entityManager.persist(stuff2);

		Customer customer = new Customer("first", "last");
		customer.setStuffs(Arrays.asList(stuff1));
		entityManager.persist(customer);

		Iterable<Stuff> findByCustomerName = stuffRepository.findByCustomersLastName(customer.getLastName());

		assertThat(findByCustomerName).extracting(Stuff::getName).containsOnly(stuff1.getName());
	}
}

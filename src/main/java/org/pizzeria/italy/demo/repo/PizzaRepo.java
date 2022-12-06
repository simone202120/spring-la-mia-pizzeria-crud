package org.pizzeria.italy.demo.repo;

import org.pizzeria.italy.demo.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PizzaRepo extends JpaRepository<Pizza,Integer> {

	

}

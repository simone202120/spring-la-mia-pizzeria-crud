package org.pizzeria.italy.demo;

import org.pizzeria.italy.demo.pojo.Pizza;
import org.pizzeria.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaMiaPizzeriaApplication implements CommandLineRunner {

	@Autowired
	private PizzaService pizzaService;
	
	public static void main(String[] args) {
		SpringApplication.run(LaMiaPizzeriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("margherita", "mozzarella", 4300);
		Pizza p2 = new Pizza("diavola", "salamino e olive", 5000);
		Pizza p3 = new Pizza("bufala", "mozzarella bufala", 4400);
		Pizza p4 = new Pizza("olive", "olive ascolane", 7900);
	
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		pizzaService.save(p4);
		

	}
}
package org.pizzeria.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.pizzeria.italy.demo.pojo.Pizza;
import org.pizzeria.italy.demo.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping
	public String getHome(Model model) {
		
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas", pizzas);
		
		return "home";
	}
	
	@GetMapping("/pizza/create")
	public String getPizzaCreate(Model model) {
		
		Pizza pizza = new Pizza();
		model.addAttribute("pizza", pizza);
		
		return "pizza-create";
	}
	@PostMapping("/pizza/create")
	public String storePizza(@Valid Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/update/{id}")
	public String getPizzaUpdate(@PathVariable("id") int id, Model model) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		model.addAttribute("pizza", pizza);
		
		return "pizza-update";
	}
	@PostMapping("/pizza/update")
	public String updatePizza(@Valid Pizza pizza) {
		
		pizzaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/delete/{id}")
	public String deletePizza(@PathVariable int id) {
		
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		
		pizzaService.delete(pizza);
		
		return "redirect:/";
	}
}

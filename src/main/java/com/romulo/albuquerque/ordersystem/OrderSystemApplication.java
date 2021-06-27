package com.romulo.albuquerque.ordersystem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.romulo.albuquerque.ordersystem.domain.Category;
import com.romulo.albuquerque.ordersystem.repositories.CategoryRepository;

@SpringBootApplication
public class OrderSystemApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
	}
	
	

}

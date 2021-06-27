package com.romulo.albuquerque.ordersystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romulo.albuquerque.ordersystem.domain.Category;
import com.romulo.albuquerque.ordersystem.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category find(Integer id){
		Optional<Category> obj = repo.findById(id);
		return obj.orElse(null);
	}

}

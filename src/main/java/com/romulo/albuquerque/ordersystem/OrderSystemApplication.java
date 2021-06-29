package com.romulo.albuquerque.ordersystem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.romulo.albuquerque.ordersystem.domain.Address;
import com.romulo.albuquerque.ordersystem.domain.Category;
import com.romulo.albuquerque.ordersystem.domain.City;
import com.romulo.albuquerque.ordersystem.domain.Client;
import com.romulo.albuquerque.ordersystem.domain.Product;
import com.romulo.albuquerque.ordersystem.domain.State;
import com.romulo.albuquerque.ordersystem.domain.enums.TypeClient;
import com.romulo.albuquerque.ordersystem.repositories.AddressRepository;
import com.romulo.albuquerque.ordersystem.repositories.CategoryRepository;
import com.romulo.albuquerque.ordersystem.repositories.CityRepository;
import com.romulo.albuquerque.ordersystem.repositories.ClientRepository;
import com.romulo.albuquerque.ordersystem.repositories.ProductRepository;
import com.romulo.albuquerque.ordersystem.repositories.StateRepository;

@SpringBootApplication
public class OrderSystemApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OrderSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00); 
		
		cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1, cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		State state1 = new State(null, "Minas Gerais");
		State state2 = new State(null, "São Paulo");
		
		City city1 = new City(null, "Uberlândia", state1);
		City city2 = new City(null, "São Paulo", state2);
		City city3 = new City(null, "Campinas", state2);
		
		state1.getCities().addAll(Arrays.asList(city1));
		state2.getCities().addAll(Arrays.asList(city2, city3));
		
		stateRepository.saveAll(Arrays.asList(state1, state2));
		cityRepository.saveAll(Arrays.asList(city1, city2, city3));
		
		Client client1 = new Client(null, "Maria Silva", "maria@gmail.com", "12345678900", TypeClient.PESSOA_FISICA);		
		
		client1.getPhones().addAll(Arrays.asList("32254878", "996578524"));
		
		Address address1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "33257875", client1, city1);
		Address address2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "58786688", client1, city2);
		
		client1.getAddress().addAll(Arrays.asList(address1, address2));
		
		clientRepository.saveAll(Arrays.asList(client1));
		addressRepository.saveAll(Arrays.asList(address1, address2));
		
	}
	
	

}

package com.romulo.albuquerque.ordersystem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romulo.albuquerque.ordersystem.domain.Client;
import com.romulo.albuquerque.ordersystem.repositories.ClientRepository;
import com.romulo.albuquerque.ordersystem.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	
	public Client find(Integer id){
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + ", Tipo: "+ Client.class.getName()));
	}

}

package com.romulo.albuquerque.ordersystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romulo.albuquerque.ordersystem.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {
	
}

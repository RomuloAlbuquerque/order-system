package com.romulo.albuquerque.projetosistemapedidos.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {
	
	@RequestMapping(method=RequestMethod.GET) 
	public String listar() {
		return "Hello World!";
	}

}

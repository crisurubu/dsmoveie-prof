package com.crisurubu.dsmovieprof.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crisurubu.dsmovieprof.dto.MovieDTO;
import com.crisurubu.dsmovieprof.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public Page<MovieDTO> findAll(Pageable pegeable){
		return service.findAll(pegeable);
		
		
	}
	
	@GetMapping(value = "/{id}")
	public MovieDTO findById(@PathVariable Long id){
		return service.findById(id);
		
		
	}
	
	

}

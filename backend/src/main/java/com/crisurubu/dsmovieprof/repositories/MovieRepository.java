package com.crisurubu.dsmovieprof.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crisurubu.dsmovieprof.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}

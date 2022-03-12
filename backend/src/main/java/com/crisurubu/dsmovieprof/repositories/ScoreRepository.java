package com.crisurubu.dsmovieprof.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crisurubu.dsmovieprof.entities.Score;
import com.crisurubu.dsmovieprof.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}

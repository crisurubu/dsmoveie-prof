package com.crisurubu.dsmovieprof.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crisurubu.dsmovieprof.dto.MovieDTO;
import com.crisurubu.dsmovieprof.dto.ScoreDTO;
import com.crisurubu.dsmovieprof.entities.Movie;
import com.crisurubu.dsmovieprof.entities.Score;
import com.crisurubu.dsmovieprof.entities.User;
import com.crisurubu.dsmovieprof.repositories.MovieRepository;
import com.crisurubu.dsmovieprof.repositories.ScoreRepository;
import com.crisurubu.dsmovieprof.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);//salva objeto atualizado
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
		}
		 //media
		double avg = sum / movie.getScores().size();
		 movie.setScore(avg);
		 movie.setCount(movie.getScores().size());
		 
		 movie = movieRepository.save(movie);
		 return new MovieDTO(movie);
		
	}
	

}

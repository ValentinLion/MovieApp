package com.esir.projet_dlc.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esir.projet_dlc.Movie;
import com.esir.projet_dlc.MovieRepository;

@Controller
public class ListeFilmsController {
	@Autowired
	
	private MovieRepository movieRepository;
	
	@GetMapping(path="/get")
	public @ResponseBody ResponseEntity getMovieDetails (@RequestParam String id) {
		Optional<Movie> m = movieRepository.findById(id);
		if(m.isPresent()) {
			return ResponseEntity.ok(m.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
    @GetMapping("/liste")
    public @ResponseBody Iterable<Movie> getAllUsers() {
		return movieRepository.findAll();
    }

}
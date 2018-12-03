package com.esir.projet_dlc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ListeFilmsController {


	@Autowired
	private FilmRepository filmRepository;



	@GetMapping("/liste")
	public String voirListeFilms(Map<String, Object> model,@RequestParam(name="search", required=false) String search, @RequestParam(name="page", required=false, defaultValue="0") int page) {

		List<Film> listeFilms;


		if(search != null && !search.equals(""))
		{
			Film film = new Film();                         
			film.setMovieTitle(search);                         
			Example<Film> example = Example.of(film);
			listeFilms = filmRepository.findAll(example);
		}
		else {
	
			listeFilms = filmRepository.findAll(new PageRequest(page, 10)).getContent();
			
		}


		model.put("listeFilms", listeFilms);
		model.put("page", page);
		
		return "liste";

	}

	@GetMapping("/film")
	public String voirDetailFilm(@RequestParam(name="id", required=true) String idFilm,Map<String, Object> model) {

		Optional<Film> film = filmRepository.findById(Long.parseLong(idFilm));

		if(film.isPresent()) {
			model.put("film",film.get());        
		}

		return "film";
	}

}
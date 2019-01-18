package com.esir.projet_dlc;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ListeFilmsController {


	@Autowired
	private FilmRepository filmRepository;


	@PostMapping("/search")
	public String rechercheFilm(Map<String, Object> model,@RequestParam String query) {

		List<Film> listeFilms;


		Film film = new Film();                         
		film.setMovieTitle(query);
		listeFilms = filmRepository.findByMovieTitle(query).subList(0, 50);

		model.put("listeFilms", listeFilms);
		
		return "liste";
	}


	@GetMapping("/liste")
	public String voirListeFilms(Map<String, Object> model, @RequestParam(name="page", required=false, defaultValue="1") int page) {


		List<Film> listeFilms = filmRepository.findAll(new PageRequest(page-1, 10)).getContent();	

		model.put("listeFilms", listeFilms);
		model.put("page", page);

		return "liste";

	}

	@GetMapping("/film")
	public String voirDetailFilm(@RequestParam(name="id", required=true) String idFilm,Map<String, Object> model) throws Exception {

		try {
			Integer.parseInt(idFilm);
		}
		catch(Exception e) {
			//L'id n'est pas un nombre
			throw new NumberFormatException("L'id du film n'est pas un nombre");
		}
		
		Optional<Film> film = filmRepository.findById(Long.parseLong(idFilm));

		if(film.isPresent()) {
			model.put("film",film.get());        
		}

		return "film";
	}

}
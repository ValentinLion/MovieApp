package com.esir.projet_dlc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ListeFilmsController {


	@Autowired
	private FilmRepository filmRepository;

	@GetMapping("/search")
	public String rechercheFilm(Map<String, Object> model) {
		List<Film> listeFilms = new ArrayList<Film>();
		model.put("listeFilms", listeFilms);
		return "liste";
	}

	@PostMapping("/search")
	public String rechercheFilm(Map<String, Object> model,@RequestParam(name="query", required=false, defaultValue="") String query) {

		List<Film> listeFilms = new ArrayList<Film>();

		if(!query.equals("")) {

			Film film = new Film();                         
			film.setMovieTitle(query);

			listeFilms = filmRepository.findByMovieTitle(query);

			if(listeFilms.size() > 50) {
				listeFilms = listeFilms.subList(0, 50);
			}
		}
		model.put("listeFilms", listeFilms);

		return "liste";
	}


	@GetMapping("/director")
	public String voirFicheRealisateur(Map<String, Object> model, @RequestParam(name="name", required=false, defaultValue="") String name) {

		List<Film> listeFilmsActeur = filmRepository.findByDirector(name);	

		model.put("name", name);
		model.put("listeFilmsActeur", listeFilmsActeur);

		return "director";

	}


	@PostMapping("/addMovie")
	public String ajoutFilm(Map<String, Object> model,@RequestParam(name="name", required=false, defaultValue="") String name
			,@RequestParam(name="actor3", required=false, defaultValue="") String actor3
			,@RequestParam(name="actor2", required=false, defaultValue="") String actor2
			,@RequestParam(name="actor1", required=false, defaultValue="") String actor1
			,@RequestParam(name="genres", required=false, defaultValue="") String genres
			,@RequestParam(name="duration", required=false, defaultValue="0") String duration
			,@RequestParam(name="titleYear", required=false, defaultValue="") String titleYear
			,@RequestParam(name="directorName", required=false, defaultValue="") String directorName
			,@RequestParam(name="imdbScore", required=false, defaultValue="0") String imdbScore
			,@RequestParam(name="urlPosterMovie", required=false, defaultValue="") String urlPosterMovie
			)
	{

		Film film = new Film();
		film.setGenres(genres);
		film.setDuration(duration);
		film.setMovieTitle(name);
		film.setDirectorName(directorName);
		film.setTitleYear(titleYear);
		film.setImdbScore((float)Integer.parseInt(imdbScore));
		film.setActor1Name(actor1);
		film.setActor2Name(actor2);
		film.setActor3Name(actor3);
		
		if(!urlPosterMovie.equals("")) {
			film.setUrlPosterMovie(urlPosterMovie);
		}
		
		film = filmRepository.save(film);
		
		if(film != null) {
			model.put("film",film);        
		}
		return "film";
	}

	
	@GetMapping("/addMovie")
	public String ajoutFilm(Map<String, Object> model) {
		return "ajoutFilm";
	}

	@GetMapping("/actor")
	public String voirFicheActeur(Map<String, Object> model, @RequestParam(name="name", required=false, defaultValue="") String name) {

		List<Film> listeFilmsActeur = filmRepository.findByActor(name);	

		model.put("name", name);
		model.put("listeFilmsActeur", listeFilmsActeur);

		return "actor";

	}


	@GetMapping("/")
	public String voirListeFilmsIndex(Map<String, Object> model, @RequestParam(name="page", required=false, defaultValue="1") int page) {


		List<Film> listeFilms = filmRepository.findAll(new PageRequest(page-1, 12,new Sort(Direction.ASC,"movieTitle"))).getContent();	

		model.put("listeFilms", listeFilms);
		model.put("page", page);

		return "liste";

	}
	
	@GetMapping("/liste")
	public String voirListeFilms(Map<String, Object> model, @RequestParam(name="page", required=false, defaultValue="1") int page) {
		
		List<Film> listeFilms = filmRepository.findAll(new PageRequest(page-1, 12,new Sort(Direction.ASC,"movieTitle"))).getContent();	

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
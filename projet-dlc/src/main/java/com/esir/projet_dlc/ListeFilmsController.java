package com.esir.projet_dlc;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ListeFilmsController {
	
	
	@Autowired
	private FilmRepository filmRepository;
	
	
	
	@GetMapping("/liste")
    public String voirListeFilms(Map<String, Object> model) {
        
        List<Film> listeFilms = filmRepository.findAll();
        
		model.put("listeFilms", listeFilms);
		model.put("test", "test");

        return "liste";
    }

	
	@GetMapping("/film")
	public String voirDetailFilm(@RequestParam(name="id", required=true, defaultValue="1") String idFilm,ModelAndView model) {
		
		Optional<Film> film = filmRepository.findById(Long.parseLong(idFilm));
		
		if(film.isPresent()) {
		        model.addObject("film",film.get());        
		}
		else {
			
		}

		return "film";
	}

}
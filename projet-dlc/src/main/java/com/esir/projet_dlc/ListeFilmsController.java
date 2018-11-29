package com.esir.projet_dlc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ListeFilmsController {
	
	
	@Autowired
	private FilmRepository filmRepository;
	
	
	
	@GetMapping("/liste")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        
        List<Film> liste = filmRepository.findAll();
        
        model.addAllAttributes(liste);        
        return "liste";
    }


}
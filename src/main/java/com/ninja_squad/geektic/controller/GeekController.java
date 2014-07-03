package com.ninja_squad.geektic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.geek.Geek;
import com.ninja_squad.geektic.service.IGeekService;

@RestController
@Transactional
@RequestMapping("/geek")
public class GeekController {
	@Autowired
	private IGeekService geekService;

	@RequestMapping(method = RequestMethod.GET, value = "/showAllGeeks")
	public List<Geek> showAllGeeks() {
		List<Geek> listeGeeks = geekService.findAll();
		return listeGeeks;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/find/{nom}/{prenom}")
    public List<Geek> showGeeksByName(
    		@PathVariable("nom") String nom,
    		@PathVariable("prenom") String prenom) {  
        return geekService.find(nom, prenom);
    }  
}

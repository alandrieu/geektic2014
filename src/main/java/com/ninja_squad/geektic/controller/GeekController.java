package com.ninja_squad.geektic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ninja_squad.geektic.geek.CentreInteret;
import com.ninja_squad.geektic.geek.Geek;
import com.ninja_squad.geektic.geek.TypeSexe;
import com.ninja_squad.geektic.service.IGeekService;

@RestController
@Transactional
@RequestMapping("/geek")
public class GeekController {
	@Autowired
	private IGeekService geekService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/trouver/{id}")
    public Geek findOne(@PathVariable("id") Long id) {  
        return geekService.findById(id);
    }

	@RequestMapping(method = RequestMethod.GET, value = "/showAllGeeks")
	public List<Geek> showAllGeeks() {
		List<Geek> listeGeeks = geekService.findAll();
		return listeGeeks;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/find/{interet}/{sexe}")
    public List<Geek> showGeeksByName(
    		@PathVariable("interet") Long interetId,
    		@PathVariable("sexe") TypeSexe sexe) {  
			return geekService.findByCritere(interetId, sexe);
    }  
	
	@RequestMapping(method = RequestMethod.GET, value ="/find/interet/{interet}")
    public List<Geek> findByInteret(@PathVariable("interet") Long interet) {  
        return geekService.findByInteret(interet);
    }
	
	@RequestMapping(method = RequestMethod.GET, value ="/find/sexe/{sexe}")
    public List<Geek> findBySexe(@PathVariable("sexe") TypeSexe sexe) {  
    	return geekService.findBySexe(sexe);
    }
}

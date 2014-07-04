package com.ninja_squad.geektic.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ninja_squad.geektic.geek.CentreInteret;
import com.ninja_squad.geektic.service.ICentreInteretService;

@RestController
@Transactional
@RequestMapping("/interets")
public class CentreInteretController {
	@Autowired
	private ICentreInteretService interetService;

	@RequestMapping(method = RequestMethod.GET, value = "/showAllinterets")
	public List<CentreInteret> showAllGeeks() {
		List<CentreInteret> listeInterets = interetService.findAll();
		return listeInterets;
	}
}
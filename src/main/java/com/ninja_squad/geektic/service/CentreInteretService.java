package com.ninja_squad.geektic.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ninja_squad.geektic.dao.ICentreInteretDao;
import com.ninja_squad.geektic.geek.CentreInteret;

@Service
public class CentreInteretService implements ICentreInteretService {
	public List<CentreInteret> listeInterets;

	@Autowired
	public ICentreInteretDao interetkDao;
	
	@Autowired
	public CentreInteretService(ICentreInteretDao interetkDao) {
		listeInterets = new ArrayList<CentreInteret>();
		this.interetkDao = interetkDao;
	}

	@Override
	public List<CentreInteret> findAll() {
		return interetkDao.findAll();
	}
}

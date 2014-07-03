package com.ninja_squad.geektic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ninja_squad.geektic.dao.IGeekDao;
import com.ninja_squad.geektic.geek.Geek;

@Service
@Transactional
public class GeekService implements IGeekService {
	
	public List<Geek> listeGeek;
	public IGeekDao geekDao;
	
	@Autowired
	public GeekService(IGeekDao geekDao) {
		listeGeek = new ArrayList<Geek>();	
		this.geekDao = geekDao;
	}
	
	@Override
	public List<Geek> findAll() {
		return geekDao.findAll();
	}

	@Override
	public Geek findById(Long id) {
		return geekDao.findById(id);
	}

	@Override
	public List<Geek> find(String nom, String prenom) {
		return geekDao.find(nom,prenom);
	}

	@Override
	public void addGeek(Geek geek){
		geekDao.addGeek(geek);
	}
}

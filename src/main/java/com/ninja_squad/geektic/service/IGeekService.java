package com.ninja_squad.geektic.service;

import java.util.List;

import com.ninja_squad.geektic.geek.CentreInteret;
import com.ninja_squad.geektic.geek.Geek;
import com.ninja_squad.geektic.geek.TypeSexe;

public interface IGeekService {
	abstract List<Geek> findAll();
	abstract Geek findById(Long id);
	abstract List<Geek> find(String nom, String prenom);
	
	
	abstract List<Geek> findBySexe(TypeSexe sexe);
	abstract List<Geek> findBySexe(TypeSexe sexe, List<Geek> preBuffuredList);
	
	abstract void addGeek(Geek geek);
	
	abstract List<Geek> findByInteret(CentreInteret interet);
	abstract List<Geek> findByInteret(CentreInteret interet, List<Geek> preBuffuredList);
	
	
	abstract List<Geek>findByCritere(Object... values);
}

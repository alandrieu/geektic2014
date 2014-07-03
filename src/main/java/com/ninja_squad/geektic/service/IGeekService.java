package com.ninja_squad.geektic.service;

import java.util.List;
import com.ninja_squad.geektic.geek.Geek;

public interface IGeekService {
	abstract List<Geek> findAll();
	abstract Geek findById(Long id);
	abstract List<Geek> find(String nom, String prenom);
	
	abstract void addGeek(Geek geek);
}

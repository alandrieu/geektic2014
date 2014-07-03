package com.ninja_squad.geektic.dao;

import java.util.List;

import com.ninja_squad.geektic.geek.Geek;
import com.ninja_squad.geektic.geek.TypeSexe;

public interface IGeekDao {
	abstract List<Geek> findAll();
	abstract void persist(Geek e);
	abstract Geek findById(Long id);
	abstract List<Geek> find(String nom, String prenom);
	abstract List<Geek> findBySexe(TypeSexe sexe);
}

package com.ninja_squad.geektic.dao;

import java.util.List;

import com.ninja_squad.geektic.geek.CentreInteret;

public interface ICentreInteretDao {
	abstract List<CentreInteret> findAll();
}

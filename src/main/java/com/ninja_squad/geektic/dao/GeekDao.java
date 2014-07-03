package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.ninja_squad.geektic.geek.Geek;

public class GeekDao implements IGeekDao {
	private EntityManager em;

	public GeekDao(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Geek> findAll() {
		String jpq1 = "select v from Spectacle as v";
		TypedQuery<Geek> query = em.createQuery(jpq1, Geek.class);
		List<Geek> liste = query.getResultList();

		return liste;
	}

	@Override
	public Geek findById(Long id) {
		return em.find(Geek.class, id);
	}

	@Override
	public void persist(Geek e) {
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		em.persist(e);
		tx.commit();
	}

	@Override
	public List<Geek> find(String nom, String prenom) {
		String jpql = "select s from GEEK s where s.nom = :nom and s.prenom = :prenom";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		
		query.setParameter("nom", nom);
		query.setParameter("prenom", prenom);

		return query.getResultList();
	}

	@Override
	public void addGeek(Geek geek) {
		// TODO Auto-generated method stub

	}
}

package com.ninja_squad.geektic.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.ninja_squad.geektic.geek.Geek;
import com.ninja_squad.geektic.geek.TypeSexe;

@Repository
public class GeekDao implements IGeekDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Geek> findAll() {
		String jpq1 = "select distinct v from Geek as v left outer join fetch v.listeCentreInteret";
		TypedQuery<Geek> query = em.createQuery(jpq1, Geek.class);
		List<Geek> liste = query.getResultList();

		return liste;
	}

	@Override
	public Geek findById(Long id) {
		//return em.find(Geek.class, id);
		
		String jpql = "select distinct s from Geek as s left outer join fetch s.listeCentreInteret where s.id = :identifier";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		
		query.setParameter("identifier", id);
		return query.getResultList().get(0); // .getResultList();
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
		String jpql = "select distinct s from Geek as s left outer join fetch s.listeCentreInteret where s.nom = :nom and s.prenom = :prenom";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
		
		query.setParameter("nom", nom);
		query.setParameter("prenom", prenom);

		return query.getResultList();
	}

	public List<Geek> findBySexe(TypeSexe sexe) {
		String jpql = "select distinct g from Geek as g left outer join fetch g.listeCentreInteret  where g.sexe = :sexe";
        TypedQuery<Geek> query = em.createQuery(jpql, Geek.class);
        
        query.setParameter("sexe", sexe);
        
        return query.getResultList();
	}

}

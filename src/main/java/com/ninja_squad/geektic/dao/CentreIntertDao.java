package com.ninja_squad.geektic.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.ninja_squad.geektic.geek.CentreInteret;

@Repository
public class CentreIntertDao implements ICentreInteretDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<CentreInteret> findAll() {
		String jpq1 = "select distinct v from CentreInteret as v left outer join fetch v.listeGeeks";
		TypedQuery<CentreInteret> query = em.createQuery(jpq1, CentreInteret.class);
		List<CentreInteret> liste = query.getResultList();

		return liste;
	}
}

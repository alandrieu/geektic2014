package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ninja_squad.geektic.geek.CentreInteret;
import com.ninja_squad.geektic.geek.Geek;
import com.ninja_squad.geektic.geek.TypeSexe;
import com.ninja_squad.geektic.service.GeekService;
import com.ninja_squad.geektic.service.IGeekService;

public class GeekDaoServiceTest {
	private IGeekDao dao;
	private IGeekService service;
	private Geek geek;

	@Before
	public void prepare() {
		dao = mock(IGeekDao.class);
		service = new GeekService(dao);

		geek = new Geek("nom", "prenom", TypeSexe.homme);
	}

	@Test
	public void findGeekByNomPrenomTest() {
		// Creation de la liste mock
		List<Geek> fakeGeek = new ArrayList<>();
		fakeGeek.add(new Geek("nom", "prenom", TypeSexe.homme));
		when(dao.find("nom", "prenom")).thenReturn(fakeGeek);

		List<Geek> expected = new ArrayList<>();
		expected.add(geek);

		List<Geek> actual = null;
		actual = service.find("nom", "prenom");
		assertEquals(expected, actual);
	}
	
	@Test
	public void findGeekByInteretCriteria() {	
		List<Geek> actual = null;

		actual = service.findByInteret(1L);
		
		// pas de retour ...
		assertTrue(!actual.isEmpty());
	}
	
	@Test
	public void findGeekBySexeCriteria() {	
		List<Geek> fakeList = new ArrayList<Geek>();
		
		fakeList.add(new Geek("toto", "homme", TypeSexe.homme));
		fakeList.add(new Geek("toto", "femme", TypeSexe.femme));

		List<Geek> actual = null;
		actual = service.findBySexe(TypeSexe.homme, fakeList);
		
		assertTrue(!actual.isEmpty());
	}
}

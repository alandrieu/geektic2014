package com.ninja_squad.geektic.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ninja_squad.geektic.geek.CentreInteret;
import com.ninja_squad.geektic.geek.Geek;
import com.ninja_squad.geektic.geek.TypeSexe;

public class GeekDaoTest extends BaseDaoTest {
	@Autowired
	private IGeekDao dao;

	@Test
	public void testFindAll() {
		List<Geek> list = dao.findAll();
		assertNotNull(list);

		// do not work
		for (Geek e : list) {
			System.out.println("\n" + "testFindAll:=" + e.getNom() + "\n");

			for (CentreInteret obj : e.getListeCentreInteret())
				System.out.println(obj.getTitre() + "-" + obj.getDescription());
		}
	}

	@Test
	public void testFindOneGeek() {
		List<Geek> list = dao.find("Landrieu", "alexis");

		assertTrue(list.get(0).getNom().equals("Landrieu")
				&& list.get(0).getPrenom().equals("alexis"));
		
		list = dao.find("Mick", "jean");

		assertTrue(list.get(0).getNom().equals("Mick")
				&& list.get(0).getPrenom().equals("jean"));

		list = dao.find("carole", "darty");

		assertTrue(list.get(0).getNom().equals("carole")
				&& list.get(0).getPrenom().equals("darty"));
	}

	@Test
	public void testFindBySexe() {
		List<Geek> list = dao.findBySexe(TypeSexe.homme);
		for (Geek e : list) {
			assertTrue(!e.getSexe().equals(TypeSexe.femme));
		}

		list = dao.findBySexe(TypeSexe.femme);
		for (Geek e : list) {
			assertTrue(!e.getSexe().equals(TypeSexe.homme));
		}
	}

	@Test
	public void testFindById() {
		Geek obj = dao.findById(0l);
		assertTrue(obj.getNom().equals("Landrieu"));
		
		System.out.println("LANDRIEU CENTRE INTERET : " +  obj.getListeCentreInteret().get(0).getTitre());

		obj = dao.findById(1l);
		assertTrue(obj.getNom().equals("Mick"));

		obj = dao.findById(2l);
		assertTrue(obj.getNom().equals("carole"));
	}
}

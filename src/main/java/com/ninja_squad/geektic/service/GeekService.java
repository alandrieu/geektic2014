package com.ninja_squad.geektic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ninja_squad.geektic.dao.IGeekDao;
import com.ninja_squad.geektic.geek.CentreInteret;
import com.ninja_squad.geektic.geek.Geek;
import com.ninja_squad.geektic.geek.TypeSexe;

@Service
public class GeekService implements IGeekService {

	public List<Geek> listeGeek;

	@Autowired
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
		return geekDao.find(nom, prenom);
	}

	@Override
	public List<Geek> findBySexe(TypeSexe sexe) {
		return geekDao.findBySexe(sexe);
	}

	@Override
	public void addGeek(Geek geek) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Geek> findByInteret(CentreInteret interet) {
		List<Geek> listAll = geekDao.findAll();

		List<Integer> deleteItem = new ArrayList<>();

		for (int i = 0; i < listAll.size(); i++) {
			Geek e = listAll.get(i);

			Boolean value = false;
			for (CentreInteret inter : e.getListeCentreInteret()) {
				if (inter == interet)
					value = true;
			}
			if (!value)
				deleteItem.add(i);
		}

		for (Integer integer : deleteItem) {
			listAll.remove(integer);
		}

		return listAll;
	}
	
	@Override
	public List<Geek>findByCritere(Object... values){
		List<Geek> listAll = this.findAll();
		   for(Object c : values){
			      if(c instanceof CentreInteret)
			    	  this.findByInteret((CentreInteret)c, listAll);
			      else if (c instanceof TypeSexe)
			    	  this.findBySexe((TypeSexe)c, listAll);
			      
			   }
		   return null;
	}

	@Override
	public List<Geek> findBySexe(TypeSexe sexe, List<Geek> preBuffuredList) {
		List<Geek> listAll = preBuffuredList;
		
		List<Integer> deleteItem = new ArrayList<>();

		for (int i = 0; i < listAll.size(); i++) {
			Geek e = listAll.get(i);

			if (e.getSexe() != sexe)
				deleteItem.add(i);
		}

		for (Integer integer : deleteItem) {
			listAll.remove(integer);
		}
		
		return null;
	}

	@Override
	public List<Geek> findByInteret(CentreInteret interet,
			List<Geek> preBuffuredList) {
		List<Geek> listAll = preBuffuredList;

		List<Integer> deleteItem = new ArrayList<>();

		for (int i = 0; i < listAll.size(); i++) {
			Geek e = listAll.get(i);

			Boolean value = false;
			for (CentreInteret inter : e.getListeCentreInteret()) {
				if (inter == interet)
					value = true;
			}
			if (!value)
				deleteItem.add(i);
		}

		for (Integer integer : deleteItem) {
			listAll.remove(integer);
		}

		return listAll;
	}

}

package com.ninja_squad.geektic.geek;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author alandrieu
 */
@Entity
@Table(name = "GEEK")
@SequenceGenerator(name = "id", sequenceName = "geek_seq")
public class Geek {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	@Column(name = "ID")
	private Long id;

	@Column
	private String nom;
	
	@Column
	private int age;

	@Column
	private String prenom;

	@Column(name = "MAIL")
	private String email;

	@Column
	@Enumerated(EnumType.STRING)
	private TypeSexe sexe;

	@Column
	private String pathavatar;

	@ManyToMany
	@JoinTable(name = "GEEK_CENTRES_INTERET", joinColumns = @JoinColumn(name = "ID_GEEK"), inverseJoinColumns = @JoinColumn(name = "ID_INTERET"))
	private List<CentreInteret> listeCentreInteret;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Long getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TypeSexe getSexe() {
		return sexe;
	}

	public void setSexe(TypeSexe sexe) {
		this.sexe = sexe;
	}

	public String getAvatar() {
		return pathavatar;
	}

	public void setAvatar(String avatar) {
		this.pathavatar = avatar;
	}

	public List<CentreInteret> getListeCentreInteret() {
		return listeCentreInteret;
	}

	public void setListeCentreInteret(List<CentreInteret> listeCentreInteret) {
		this.listeCentreInteret = listeCentreInteret;
	}

	protected Geek() {}

	public Geek(String nom, String prenom, TypeSexe sexe) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
	}
	
	public Geek(String nom, int age, String prenom, String email,
			TypeSexe sexe, String pathavatar,
			List<CentreInteret> listeCentreInteret) {
		super();
		this.nom = nom;
		this.age = age;
		this.prenom = prenom;
		this.email = email;
		this.sexe = sexe;
		this.pathavatar = pathavatar;
		this.listeCentreInteret = listeCentreInteret;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime
				* result
				+ ((listeCentreInteret == null) ? 0 : listeCentreInteret
						.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result
				+ ((pathavatar == null) ? 0 : pathavatar.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Geek other = (Geek) obj;
		if (age != other.age)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (listeCentreInteret == null) {
			if (other.listeCentreInteret != null)
				return false;
		} else if (!listeCentreInteret.equals(other.listeCentreInteret))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (pathavatar == null) {
			if (other.pathavatar != null)
				return false;
		} else if (!pathavatar.equals(other.pathavatar))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (sexe != other.sexe)
			return false;
		return true;
	}
}

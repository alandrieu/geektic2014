package com.ninja_squad.geektic.geek;

import java.io.File;
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

/**
 * 
 * @author alandrieu
 *
 */
@Entity
@SequenceGenerator(name="id",sequenceName="geek_seq")
public class Geek {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id")
    @Column(name="ID")
	private Long id;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String email;
	
	@Column
	@Enumerated(EnumType.STRING)
	private TypeSexe sexe;
	
	@Column
	private String avatar;
	
	@ManyToMany
    @JoinTable(name = "GEEK_INTERET",
               joinColumns = @JoinColumn(name = "IDGEEK"),
               inverseJoinColumns = @JoinColumn(name = "IDINTERET"))
	private List<CentreInteret> listeCentreInteret;
	
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
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<CentreInteret> getListeCentreInteret() {
		return listeCentreInteret;
	}
	public void setListeCentreInteret(List<CentreInteret> listeCentreInteret) {
		this.listeCentreInteret = listeCentreInteret;
	}
	
	public Geek() {
	}
	
	public Geek(String nom, String prenom, TypeSexe sexe) {
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
	}
	
	public Geek(String nom, String prenom, String email, TypeSexe sexe,
			String avatar, List<CentreInteret> listeCentreInteret) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.sexe = sexe;
		this.avatar = avatar;
		this.listeCentreInteret = listeCentreInteret;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatar == null) ? 0 : avatar.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((listeCentreInteret == null) ? 0 : listeCentreInteret
						.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		if (avatar == null) {
			if (other.avatar != null)
				return false;
		} else if (!avatar.equals(other.avatar))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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

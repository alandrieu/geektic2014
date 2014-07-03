package com.ninja_squad.geektic.geek;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author alandrieu
 */
@Entity
@Table(name="CENTRES_INTERET")
@SequenceGenerator(name="id",sequenceName="geek_seq")
public class CentreInteret {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id")
    @Column(name="ID")
	private Long id;
	
	@Column
	private String titre;
	
	@Column
	private String description;
	
	@ManyToMany(mappedBy="listeCentreInteret")
	private List<Geek> listeGeeks;

	protected CentreInteret() {}
	
	public CentreInteret(String titre, String description) {
		this.titre = titre;
		this.description = description;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}
}

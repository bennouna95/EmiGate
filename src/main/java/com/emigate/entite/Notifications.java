package com.emigate.entite;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Notifications {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	
	@ManyToMany(targetEntity = Utilisateur.class)
	   private List<Utilisateur> UtilisateurList;
	
	private String description;

	 



	public Notifications() {
		super();
	}


	public Notifications(String description,List<Utilisateur> utilisateurList) {
		super();
		UtilisateurList = utilisateurList;
		this.description = description;
	}

	 
	public List<Utilisateur> getUtilisateurList() {
		return UtilisateurList;
	}

	public void setUtilisateurList(List<Utilisateur> utilisateurList) {
		UtilisateurList = utilisateurList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	 

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}

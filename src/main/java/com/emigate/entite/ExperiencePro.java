package com.emigate.entite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
@Entity
public class ExperiencePro implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@javax.persistence.Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
 	private String titre;
	private String dateDebut;
	private String dateFin;
 	private String description;
 	
 	@ManyToOne
 	private CV cv;
 	
 	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	 
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getDateFin() {
		return dateFin;
	}
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ExperiencePro(Long id, String titre,  String dateDebut, String dateFin, String description) {
		super();
		Id = id;
		this.titre = titre;
 		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.description = description;
	}
	public ExperiencePro() {
		super();
	}
	public ExperiencePro(String fonction, String dd, String df, String description) {
		// TODO Auto-generated constructor stub
		this.titre = fonction;
 		this.dateDebut = dd;
		this.dateFin = df;
		this.description = description;
	}
	public ExperiencePro(String fonction, String dd, String df, String description, CV cv) {
		// TODO Auto-generated constructor stub
		this.titre = fonction;
 		this.dateDebut = dd;
		this.dateFin = df;
		this.description = description;
		this.cv=cv;
	}
	
	
	
	

}

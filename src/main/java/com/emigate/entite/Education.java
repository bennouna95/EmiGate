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
public class Education implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@javax.persistence.Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
 	private String ecole;
    
 	 private String dateDebut;
 	 private String dateFin;
 	private String diplome;
 	
 	@ManyToOne
 	CV cv;
 	
 	public Education(String ecole, String dd, String df, String description, CV cv) {
		
		this.ecole = ecole;
		this.dateDebut = dd;
		this.dateFin = df;
		this.diplome = description;
		this.cv=cv;
		
	}
 	
	public Education() {
		super();
	}
	public Education(Long id, String ecole, String dateDebut,String dateFin, String diplome) {
		super();
		Id = id;
		this.ecole = ecole;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.diplome = diplome;
	}
	public Education(String ecole, String dd, String df, String diplome) {
		// TODO Auto-generated constructor stub
		this.ecole = ecole;
		this.dateDebut = dd;
		this.dateFin = df;
		this.diplome = diplome;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getEcole() {
		return ecole;
	}
	public void setEcole(String ecole) {
		this.ecole = ecole;
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
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

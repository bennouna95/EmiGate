package com.emigate.entite;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Competence implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
 	private String competence;
 	private int niveau;
 	
    @ManyToOne
 	private CV cv;
 	
 	
 	
 	
 	
 	
	 public Competence(String competence, int niveau, CV cv) {
		super();
		this.competence = competence;
		this.niveau = niveau;
		this.cv = cv;
	}
	public Long getId() {
	return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
 	
	 
	public String getCompetence() {
		return competence;
	}
	public void setCompetence(String competence) {
		this.competence = competence;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Competence() {
		super();
	}
	public Competence(String competence, int niveau) {
		// TODO Auto-generated constructor stub
		this.competence=competence;
		this.niveau=niveau;
	}
	public Competence(String competence2, int parseInt, Long long1) {
		// TODO Auto-generated constructor stub
		setCompetence(competence2);
		setId(long1);
		setNiveau(parseInt);
	}
	 
	
	
	
	

}

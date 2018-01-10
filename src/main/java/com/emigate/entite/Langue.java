package com.emigate.entite;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Langue implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
 	private String langue;
 	private int niveau;
 	
 	@ManyToOne
 	CV cv;
	 
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
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
	public Langue(String langue, int niveau) {
		super();
		this.langue = langue;
		this.niveau = niveau;
	}
	public Langue() {
		super();
	}
	public Langue(String langue2, int parseInt, Long long1) {
		// TODO Auto-generated constructor stub
		
		setId(long1);
		setLangue(langue2);
		setNiveau(parseInt);
	}
	public Langue(String langue, int parseInt, CV cv) {
		// TODO Auto-generated constructor stub
		setLangue(langue);
		setNiveau(parseInt);
		this.cv=cv;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}

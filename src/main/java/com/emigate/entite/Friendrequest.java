package com.emigate.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Friendrequest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public Friendrequest() {
		super();
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Friendrequest(Long user_id_one, Long user_id_two, int status) {
		super();
		this.user_id_one = user_id_one;
		this.user_id_two = user_id_two;
		this.status = status;
	}
	private Long user_id_one;
	
	private Long user_id_two;

	
	@ManyToOne
 	private Utilisateur utilisateur;
	
	@Column(name="status", columnDefinition="Integer default '0'")
	private int status;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getUser_id_one() {
		return user_id_one;
	}
	public void setUser_id_one(Long user_id_one) {
		this.user_id_one = user_id_one;
	}
	
	public Long getUser_id_two() {
		return user_id_two;
	}
	public void setUser_id_two(Long user_id_two) {
		this.user_id_two = user_id_two;
	}


}

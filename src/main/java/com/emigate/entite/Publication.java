package com.emigate.entite;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Publication {

	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	
	private String title;
	
	private String body;
	
	private String img;
	
	private Date date;
	
	private String type;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Utilisateur author;
	
	public Utilisateur getAuthor() {
		return author;
	}
	public void setAuthor(Utilisateur author) {
		this.author = author;
	}
	public Publication(Long id, String title, String body, String img, Date date) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.img = img;
		this.date = date;
	}
	public Publication() {
		super();
	}
	
	public Publication(String title, String body, String img) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.body = body;
		this.img = img;
	}
	
	public Publication(String title, String body, String img,Utilisateur user) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.body = body;
		this.img = img;
		this.author =user;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}

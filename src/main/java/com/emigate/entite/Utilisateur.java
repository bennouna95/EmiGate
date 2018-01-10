package com.emigate.entite;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Utilisateur implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@javax.persistence.Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
 
	private String nom;
	
	private String prenom;
	
	private String adresse;
	
	private String tel;
	
	private String dateNaissance;
	
	private String genie;
	
	private String sexe;
	
	
	public Utilisateur(String nom, String prenom, String tel, String dateNaissance, String sexe, String motdepasse,
			String email, String img, String genie , String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.dateNaissance = dateNaissance;
		this.sexe = sexe;
		this.motdepasse = motdepasse;
		this.email = email;
		this.img = img;
		this.genie=genie;
		this.adresse=adresse;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	
	@ManyToMany(targetEntity = Notifications.class)
	   private List<Notifications> NotificationList;
	
	
	 

	public List<Notifications> getNotificationList() {
		return NotificationList;
	}

	public void setNotificationList(List<Notifications> notificationList) {
		NotificationList = notificationList;
	}

	@Column(nullable = false)
	private String motdepasse;
	
	@Column(unique=true)
	private String email;
	
	@OneToMany()
	private Set<Utilisateur> cercleAmis= new HashSet<Utilisateur>();;
	@Column(columnDefinition="varchar(255) DEFAULT 'icon.png'")
	private String img ;	
	
	@OneToMany()
	private Set<Publication> publications = new HashSet<Publication>();
 	
		
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public Set<Utilisateur> getCercleAmis() {
		return cercleAmis;
	}

	public void setCercleAmis(Set<Utilisateur> cercleAmis) {
		this.cercleAmis = cercleAmis;
	}

	public Set<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}

	
	
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getImage() {
		return img;
	}
	public void setImage(String image) {
		this.img = image;
	}
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Utilisateur(Long id,String nom, String prenom, String dateNaissance,
			String image) {
		super();
		this.id = id;
		 
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.img = image;
	}
	public Utilisateur() {
		super();
	}
	

	public String getAdress() {
		return adresse;
	}

	public void setAdress(String adress) {
		this.adresse = adress;
	}

	public Utilisateur(Long id, String nom, String prenom, String adress, String tel, String dateNaissance,
			Set<Utilisateur> cercleAmis, String image, String email,  Set<Publication> publications) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adress;
		this.tel = tel;
		this.dateNaissance = dateNaissance;
		this.cercleAmis = cercleAmis;
		this.img = image;
		this.email = email;
		this.publications = publications;
	}

	public Utilisateur(String email, String motdepasse) {

		this.email=email;
		this.motdepasse=motdepasse;
	}

	public Utilisateur(String email, String motdepasse, String nom) {
		// TODO Auto-generated constructor stub
		this.email=email;
		this.motdepasse=motdepasse;
		this.nom=nom;
	}

	public String getMotDepasse() {
		return motdepasse;
	}

	public void setMotDepasse(String motDepasse) {
		this.motdepasse = motDepasse;
	}

	public String getGenie() {
		return genie;
	}

	public void setGenie(String genie) {
		this.genie = genie;
	}

	
}

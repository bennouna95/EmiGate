package com.emigate.metier;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.emigate.entite.Utilisateur;

public interface IUtilisateur {
	
	public void ajouterUtilisateur(Utilisateur u);

	void enrigestrer(MultipartFile file, String nom, Long id) throws IOException;
	public void deleteImage(String image);
	Resource telecharger(String nom);
	void ModifierPersoInfo(String genie, String adresse, String tel, Long id);
	Utilisateur TrouverUserParId(Long id);

	public List<Utilisateur> searchUtilisateur(String rech);
	public List<Utilisateur> searchNom(String rech);
	public List<Utilisateur> searchPrenom(String rech);
	public List<Utilisateur> searchAdresse(String rech);
	public List<Utilisateur> searchTel(String rech);
	public List<Utilisateur> searchGenie(String rech);
	Resource telechargerImagePub(String nom);

}

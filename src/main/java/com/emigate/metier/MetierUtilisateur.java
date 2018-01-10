package com.emigate.metier;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.emigate.Repository.UtilisateurRepository;
import com.emigate.entite.Image;
import com.emigate.entite.Utilisateur;

@Service
@Transactional
public class MetierUtilisateur  implements IUtilisateur{

	@Autowired
	UtilisateurRepository ur;
	
	private final Path rootLocation = Paths.get("p");
	private final Path rootLocationPub = Paths.get("publication");

	
	@Override
	public void ajouterUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub
		ur.save(u);
		
	}
	
	@Override
	public void enrigestrer(MultipartFile file, String nom,Long id) throws IOException {

		String[] imgFormats = { "jpg", "png", "jpeg" };
		String[] partie = file.getOriginalFilename().split("\\.");
		String format = partie[1];

		if (Arrays.asList(imgFormats).contains(format)) {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(nom + "." + format));
			ur.ModifierImage(nom + "." + format, id);
		} else
			throw new RuntimeException(" Vérifier le format de votre image ");

	}
	
	@Override
	public void deleteImage(String image) {
		try {
			Files.deleteIfExists(this.rootLocation.resolve(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Resource telecharger(String nom) {
		try {
			Path file = rootLocation.resolve(nom);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException(" votre fichier inéxistant");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("votre fichier inéxistant");
		}
	}
	
	@Override
	public void ModifierPersoInfo(String genie,String adresse,String tel,Long id){
		ur.ModifierPersoInfo(genie, adresse, tel, id);
	}

	@Override
	public Utilisateur TrouverUserParId(Long id) {
		// TODO Auto-generated method stub
		return ur.TrouverUserParId(id);
	}


	@Override
	public Resource telechargerImagePub(String nom) {
		try {
			Path file = rootLocationPub.resolve(nom);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException(" votre fichier inexistant");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("votre fichier inexistant");
		}
	}
	@Override
	public List<Utilisateur> searchUtilisateur(String rech) {
	return ur.chercherUtilisateur(rech);
	}
	
	public List<Utilisateur> searchNom(String rech) {
		return ur.chercherNom(rech);
		}
	
	public List<Utilisateur> searchPrenom(String rech) {
		return ur.chercherPrenom(rech);
		}
	
	public List<Utilisateur> searchAdresse(String rech) {
		return ur.chercherAdresse(rech);
		}
	
	public List<Utilisateur> searchTel(String rech) {
		return ur.chercherTel(rech);
		}
	
	public List<Utilisateur> searchGenie(String rech) {
		return ur.chercherGenie(rech);
		}
}

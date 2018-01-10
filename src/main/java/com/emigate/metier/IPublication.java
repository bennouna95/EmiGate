package com.emigate.metier;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.emigate.entite.Publication;

public interface IPublication {
	
	 List<Publication> findAll();
	    List<Publication> findLatest5();
	    Publication findById(Long id);
	    Publication create(Publication Publication);
	    Publication edit(Publication Publication);
	    void deleteById(Long id);
	    public void enregistrer(MultipartFile file, String nom);
	    public Resource telecharger(String nom);
	    public List<Publication> getPublicationsByUserId(Long id);
	    
	    public List<Publication> searchPublication(String rech);
		public List<Publication> searchTitle(String rech);
		public List<Publication> searchBody(String rech);

}

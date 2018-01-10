package com.emigate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.emigate.entite.Image;


public interface  ImageRepo extends JpaRepository<Image,Long> {
	
	
	
	@Modifying
	@Query("update Image image set image.nom = ?1")
	void ModifierImage( String nom);
	
	
	@Query("select i from Image i where i.nom like ?1")
	Image TrouverImageParNom(String nom);
	
	
}
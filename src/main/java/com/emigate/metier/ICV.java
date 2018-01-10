package com.emigate.metier;

import java.util.List;
/*
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;*/
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emigate.entite.CV;
 
public interface ICV {
	
	public void AjouterCV(CV c);
	public List<CV> getAllCVs();
 	public void MAJCV(CV c);
	public void supprimerCV(CV c);
	CV TrouverCvById(Long id);
	CV trouverById(Long id);
	
	/*@Modifying
	@Query("update CV cv set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
	void setUserInfoById(String firstname, String lastname, Integer userId);*/

}

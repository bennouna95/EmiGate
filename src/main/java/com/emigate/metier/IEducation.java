package com.emigate.metier;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emigate.entite.Education;

 
public interface IEducation {
	

	public void AjouterEducation(Education c);
	public List<Education> getAllEducations();
 	public void MAJEducation(Education c);
	public void supprimerEducation(Education c);
	public void supprimerEducation(Long id);
	Set<Education> getEducationById(Long id);


}

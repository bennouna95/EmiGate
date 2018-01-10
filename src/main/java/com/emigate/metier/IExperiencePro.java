package com.emigate.metier;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emigate.entite.ExperiencePro;

 
public interface IExperiencePro {
	

	public void AjouterExperiencePro(ExperiencePro c);
	public List<ExperiencePro> getAllExperiencePros();
 	public void MAJExperiencePro(ExperiencePro c);
	public void supprimerExperiencePro(ExperiencePro c);
	public void supprimerExperiencePro(Long id);
	Set<ExperiencePro> getExpById(Long id);




}

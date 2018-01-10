package com.emigate.metier;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emigate.entite.Competence;


public interface ICompetence {

	public void AjouterCompetence(Competence c);
	public List<Competence> getAllCompetences();
 	public void MAJCompetence(Competence c);
	public void supprimerCompetence(Competence c);
	public void supprimerCompetence(Long long1);
	Set<Competence> TrouverCompetenceById(Long id);

}

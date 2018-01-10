package com.emigate.metier;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emigate.Repository.CompeteneceRepository;
import com.emigate.entite.Competence;


@Service 
@Transactional
public class MetierCompetence implements ICompetence {
	
	@Autowired
	CompeteneceRepository cr;

	@Override
	public void AjouterCompetence(Competence c) {
		// TODO Auto-generated method stub
		cr.save(c);
	}

	@Override
	public List<Competence> getAllCompetences() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}

	@Override
	public void MAJCompetence(Competence c) {
		// TODO Auto-generated method stub
		cr.ModifierCompetence(c.getCompetence(),c.getNiveau(),c.getId());
	}

	@Override
	public void supprimerCompetence(Competence c) {
		// TODO Auto-generated method stub
		cr.delete(c);
	}

	@Override
	public void supprimerCompetence(Long long1) {
		// TODO Auto-generated method stub
		cr.deleteById(long1);
	}
	
	@Override
	public Set<Competence> TrouverCompetenceById(Long id){
		return cr.TrouverCompetncebyByCvId(id);
	}

}

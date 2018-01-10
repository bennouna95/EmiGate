package com.emigate.metier;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emigate.Repository.ExperienceProRepository;
import com.emigate.entite.ExperiencePro;

@Service   
@Transactional
public class MetierExperiencePro implements IExperiencePro{

	
	@Autowired
	ExperienceProRepository epr;
	
	@Override
	public void AjouterExperiencePro(ExperiencePro c) {
		// TODO Auto-generated method stub
		epr.save(c);
		}

	@Override
	public List<ExperiencePro> getAllExperiencePros() {
		// TODO Auto-generated method stub
		return epr.findAll();
	}

	@Override
	public void MAJExperiencePro(ExperiencePro c) {
		// TODO Auto-generated method stub
		
		
		epr.ModifierExp(c.getTitre(), c.getDateDebut(),c.getDateFin(),c.getDescription(),c.getId());
	}

	@Override
	public void supprimerExperiencePro(ExperiencePro c) {
		// TODO Auto-generated method stub
		epr.delete(c);
	}
	
	@Override
	public void supprimerExperiencePro(Long id) {
		// TODO Auto-generated method stub
		epr.deleteById(id);
	}
	
	
	@Override
	public Set<ExperiencePro> getExpById(Long id){
		return epr.TrouverExpByCvId(id);
	}
	

}

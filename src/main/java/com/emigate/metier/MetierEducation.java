package com.emigate.metier;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emigate.Repository.EducationRepository;
import com.emigate.entite.Education;

@Service   
@Transactional
public class MetierEducation implements IEducation {
	
	@Autowired
	EducationRepository er;

	@Override
	public void AjouterEducation(Education c) {
		// TODO Auto-generated method stub
		er.save(c);
	}

	@Override
	public List<Education> getAllEducations() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public void MAJEducation(Education c) {
		// TODO Auto-generated method stub
		er.ModifierEducation(c.getEcole() ,c.getDateDebut(),c.getDateFin(),c.getDiplome(),c.getId());
	}

	@Override
	public void supprimerEducation(Education c) {
		// TODO Auto-generated method stub
		er.delete(c);
	}

	public void supprimerEducation(Long id) {
		// TODO Auto-generated method stub
		er.deleteById(id);
	}
	
	@Override
	public Set<Education> getEducationById(Long id){
		return er.TrouverEducationbyByCvId(id);
		
	}

	
}

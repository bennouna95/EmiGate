package com.emigate.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emigate.Repository.CVRepository;
import com.emigate.entite.CV;

@Service   
@Transactional
public class MetierCV implements ICV{

	@Autowired
	CVRepository cvr;
	
	@Override
	public void AjouterCV(CV c) {
		// TODO Auto-generated method stub
		cvr.save(c);
	}

	@Override
	public List<CV> getAllCVs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void MAJCV(CV c) {
		// TODO Auto-generated method stub
		cvr.save(c);
	}

	@Override
	public void supprimerCV(CV c) {
		// TODO Auto-generated method stub
		cvr.delete(c);
	}
	
	@Override
	public CV TrouverCvById(Long id){
		return cvr.TrouverCvByCvId(id);
	}
	
	@Override
	public CV trouverById(Long id){
		return cvr.getOne(id);
		
		
	}

}

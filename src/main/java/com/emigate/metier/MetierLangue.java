package com.emigate.metier;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emigate.Repository.LangueRepository;
import com.emigate.entite.Langue;

@Service   
@Transactional
public class MetierLangue implements ILangue {

	@Autowired
	LangueRepository lr;
	
	@Override
	public void AjouterLangue(Langue c) {
		// TODO Auto-generated method stub
		lr.save(c);
	}

	@Override
	public List<Langue> getAllLangues() {
		// TODO Auto-generated method stub
		return lr.findAll();
	}

	@Override
	public void MAJLangue(Langue c) {
		// TODO Auto-generated method stub
		lr.ModifierLangue(c.getLangue(),c.getNiveau(),c.getId());;
	}

	@Override
	public void supprimerLangue(Langue c) {
		// TODO Auto-generated method stub
		lr.delete(c);
	}
	public void supprimerLangue(Long id) {
		// TODO Auto-generated method stub
		
		lr.deleteById(id);
	}
	
	@Override
	public Set<Langue> getLangueByCvId(Long id){
		return lr.TrouverLanguebyByCvId(id);
		
	}
	
	
}

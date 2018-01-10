package com.emigate.metier;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emigate.entite.Langue;

public interface ILangue {
	
	public void AjouterLangue(Langue c);
	public List<Langue> getAllLangues();
 	public void MAJLangue(Langue c);
	public void supprimerLangue(Langue c);
	void supprimerLangue(Long id);
	Set<Langue> getLangueByCvId(Long id);

}

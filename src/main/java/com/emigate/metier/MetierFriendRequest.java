package com.emigate.metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emigate.Repository.FriendRequestRepository;
import com.emigate.Repository.UtilisateurRepository;
import com.emigate.entite.Friendrequest;
import com.emigate.entite.Utilisateur;

@Service 
@Transactional
public class MetierFriendRequest implements IFriendRequest {

	@Autowired
	FriendRequestRepository cr;
	
	@Autowired
	UtilisateurRepository ur;
	
	@Override
	public void createFriendRequest(Friendrequest ut) {
		cr.save(ut);
	}

	


	@Override
	public void accepter(Long id1, Long id2)  {
		cr.accepter(1,id1, id2);
	}

	@Override
	public void refuser(Long id1, Long id2) {
		cr.refuser(2,id1, id2);

	}

	@Override
	public List<Utilisateur> getAmis(Long id) {
		// TODO Auto-generated method stub
		Utilisateur u;
		List<Friendrequest>  frs = cr.TrouverFRById(id, 1);
		
		List<Utilisateur> amis=new ArrayList<Utilisateur>();
		
		for (Friendrequest fr  : frs) {
			if(!fr.getUser_id_one().equals(id))
				u = ur.getOne(fr.getUser_id_one());
			else
				u = ur.getOne(fr.getUser_id_two());
			amis.add(u);							
		}		
		return 	amis;	
		
	}
	
	@Override
	public List<Utilisateur> FriendRequests(Long id) {
		Utilisateur u;
		List<Friendrequest>  frs = cr.TrouverRById(id, 0);
		
		List<Utilisateur> amis=new ArrayList<Utilisateur>();
		
		for (Friendrequest fr  : frs) {
			u = ur.getOne(fr.getUser_id_one());
			amis.add(u);							
		}		
		return 	amis;	
	}
	
	public boolean EstAmi(Long id1,Long id2){
		return cr.EstAmi(id1, id2) != null;
	}
	
	public boolean EstAttenteAmi(Long id1,Long id2){
		return cr.EstAttenteAmi(id1, id2) != null;
	}
	

}

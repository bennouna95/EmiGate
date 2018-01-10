package com.emigate.metier;

import java.util.List;
import java.util.Set;

import com.emigate.entite.Friendrequest;
import com.emigate.entite.Utilisateur;


public interface IFriendRequest {
	public void createFriendRequest(Friendrequest ut);
	
	public List<Utilisateur> getAmis(Long id);
	
	public List<Utilisateur> FriendRequests(Long id);
	
	public void accepter(Long id_1, Long id_2) ;
	
	public void refuser(Long id_1, Long id_2) ;

	public boolean EstAmi(Long id1,Long id2) ;
	
	public boolean EstAttenteAmi(Long id1,Long id2) ;


}

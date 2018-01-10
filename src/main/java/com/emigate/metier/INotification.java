package com.emigate.metier;

import java.util.List;
import java.util.Set;

import com.emigate.entite.Notifications;
import com.emigate.entite.Utilisateur;

public interface INotification {
	
 	
	void supprimerNotification(Long id);

	void EnvoyerNotification(String not, List<Utilisateur> amis);
	
	List<Notifications> getNotificationsByUserId(Long id);

}

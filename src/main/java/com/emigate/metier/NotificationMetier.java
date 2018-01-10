package com.emigate.metier;

import java.util.List;
import java.util.Set;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emigate.Repository.NotificationRepo;
import com.emigate.entite.Notifications;
import com.emigate.entite.Utilisateur;
 
@Service
public class NotificationMetier implements INotification {
	
	
	@Autowired
	NotificationRepo nr;

 

	@Override
	public void supprimerNotification(Long id) {
		// TODO Auto-generated method stub
 		nr.deleteById(id);
 	
	}



	@Override
	public void EnvoyerNotification(String not, List<Utilisateur> amis) {
		// TODO Auto-generated method stub
		Notifications notification = new Notifications (not,amis);
		nr.save(notification);
	}



	@Override
	public List<Notifications> getNotificationsByUserId(Long id) {
		// TODO Auto-generated method stub
		return nr.GetNotificationsByUserId(id);
	}
 
}

package com.emigate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emigate.Repository.UtilisateurRepository;
import com.emigate.entite.Response;
import com.emigate.entite.Utilisateur;
import com.emigate.metier.INotification;
import com.emigate.metier.IUtilisateur;

  
@RestController
public class NotificationController {
	
	@Autowired
	INotification in;
	
	@Autowired
	IUtilisateur iu;
	
	@Autowired
	UtilisateurRepository ur;
	
	Utilisateur utilisateur ;
	Authentication auth;
    String name;
 	
	 @RequestMapping(value = "/getNotifications", method = RequestMethod.GET)
	    public Response getResource() {
		 
		    auth = SecurityContextHolder.getContext().getAuthentication();
		    name = auth.getName();
			utilisateur = ur.TrouverUserParEmail(name);
	        Response response = new Response("Done",in.getNotificationsByUserId(utilisateur.getId()));
	        return response;
	    }
}

package com.emigate.controller;



import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emigate.Repository.UtilisateurRepository;
import com.emigate.entite.Publication;
import com.emigate.entite.Utilisateur;
import com.emigate.metier.IPublication;
import com.emigate.metier.IUtilisateur;

@Controller
public class SearchController {

	@Autowired
	IUtilisateur mpro;
	@Autowired
	IPublication mpub;
	
	 Authentication auth;
	 String name;
	 Utilisateur utilisateur ;
	 

		@Autowired
		UtilisateurRepository ur;
	
	 
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String search(String choix,String rech,Model model){
		
		auth = SecurityContextHolder.getContext().getAuthentication();
		name = auth.getName();
		utilisateur = ur.TrouverUserParEmail(name);
		model.addAttribute("utilisateur",utilisateur);
		
		String pro="Profils";
		String pub="Publications";
		
		Hashtable<Publication,Utilisateur> hpubs = new Hashtable<Publication,Utilisateur>();

		
		if(choix.equals(pro))
		{
			String s[]=rech.split(" ");
			List<Utilisateur> profils=mpro.searchUtilisateur(s[0]);
			for(int i=1;i<s.length;i++)
			{
				profils.addAll(mpro.searchUtilisateur(s[i]));
			}
			for(int i=0;i<profils.size();i++)
			{
				for(int j=0;j<profils.size();j++)
				{
					if(j!=i )
					{
						if(profils.get(i).getId()==profils.get(j).getId())
						{profils.remove(j);}
					}
				}
			}
			
			model.addAttribute("choix",choix);
			model.addAttribute("profils",profils);
		}
		else if(choix.equals(pub))
		{
			String s[]=rech.split(" ");
			List<Publication> publications=mpub.searchPublication(s[0]);
			for(int i=1;i<s.length;i++)
			{
				publications.addAll(mpub.searchPublication(s[i]));
			}
			for(int i=0;i<publications.size();i++)
			{
				for(int j=0;j<publications.size();j++)
				{
					if(j!=i )
					{
						if(publications.get(i).getId()==publications.get(j).getId())
							{publications.remove(j);}
					}
				}
			}
			for( Publication p : publications){
				hpubs.put(p, p.getAuthor());
			}
 			model.addAttribute("choix",choix);
			model.addAttribute("publications",hpubs);
		} 
		return "result";
	}
	@RequestMapping("/rechAv")
	public String rechAv( Model model){
		auth = SecurityContextHolder.getContext().getAuthentication();
		name = auth.getName();
		utilisateur = ur.TrouverUserParEmail(name);
		model.addAttribute("utilisateur",utilisateur);
		return "rechAv";
		}
	

	@RequestMapping(value="/effectuerRechAvPro", method = RequestMethod.POST)
	public String effectuerRechAvPro(String nom,String prenom,String genie,String adresse,String description,String tel,Model model ){
		auth = SecurityContextHolder.getContext().getAuthentication();
		name = auth.getName();
		utilisateur = ur.TrouverUserParEmail(name);
		model.addAttribute("utilisateur",utilisateur);
		
		List<Utilisateur> profils=mpro.searchNom(nom);
		if(prenom.equals("")==false)
		profils.retainAll(mpro.searchPrenom(prenom));
		if(adresse.equals("")==false)
			profils.retainAll(mpro.searchAdresse(adresse));
		if(genie.equals("")==false)
			profils.retainAll(mpro.searchGenie(genie));
		 
		
		if(tel.equals("")==false)
			profils.retainAll(mpro.searchTel(tel));
		
		
		model.addAttribute("profils",profils);
		return "effectuerRechAvPro";
	}
	@RequestMapping(value="/effectuerRechAvPub", method = RequestMethod.POST)
	public String effectuerRechPub(String title,String body,Model model ){
		auth = SecurityContextHolder.getContext().getAuthentication();
		name = auth.getName();
		utilisateur = ur.TrouverUserParEmail(name);
		model.addAttribute("utilisateur",utilisateur);
		List<Publication> publications=mpub.searchTitle(title);
		if(body.equals("")==false)
		publications.retainAll(mpub.searchBody(body));

		Hashtable<Publication,Utilisateur> hpubs = new Hashtable<Publication,Utilisateur>();

		
		for( Publication p : publications){
			hpubs.put(p, p.getAuthor());
		}
		model.addAttribute("publications",hpubs);
		
		return "effectuerRechAvPub";
	}
}

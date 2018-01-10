package com.emigate.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emigate.Repository.UtilisateurRepo;
import com.emigate.entite.Utilisateur;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	 private final UtilisateurRepo userRepository;
	  
	 @Autowired
	    public CustomUserDetailsService(UtilisateurRepo userRepository) {
	        this.userRepository = userRepository;
	    }
	  
	         
	 @Override
	 public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	  Utilisateur user=userRepository.TrouverUserParEmail(email);
	  if(null == user){
	   throw new UsernameNotFoundException(email);
	  }else{
	   return new CustomUserDetails(user);
	  }
	 }
	   

}

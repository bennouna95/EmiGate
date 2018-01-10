package com.emigate.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.emigate.Repository.UtilisateurRepository;
import com.emigate.entite.Utilisateur;

 
public final class UtilisateurDetailService implements UserDetailsService {

	@Autowired
	private UtilisateurRepository uRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utilisateur u = uRepo.TrouverUserParEmail(email);
		System.out.println(u.getEmail());
		if (u == null)
			throw new UsernameNotFoundException(String.format("User with the username %s doesn't exist", email));
		List<GrantedAuthority> authorities = new ArrayList<>();
	 
		return new org.springframework.security.core.userdetails.
				User(u.getEmail(), u.getMotdepasse(), authorities);
	}

}

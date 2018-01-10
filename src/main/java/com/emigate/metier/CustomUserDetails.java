package com.emigate.metier;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.emigate.entite.Utilisateur;


public class CustomUserDetails extends Utilisateur implements UserDetails { 
	  
	 private static final long serialVersionUID = 1L;
	  
	

	public CustomUserDetails(Utilisateur u) {
		super(u.getEmail(),u.getMotDepasse());
	} 
	 @Override
	 public boolean isAccountNonExpired() {  
	  return true;
	 }
	 @Override
	 public boolean isAccountNonLocked() {
	  return true;
	 }
	  
	 @Override
	 public boolean isCredentialsNonExpired() {
	  return true;
	 }
	 @Override
	 public boolean isEnabled() {
	  return true;
	 }
	 
	 
	 @Override
	 public String getUsername() {
	  return super.getEmail();
	 }

	 @Override
 	public String getName() {
		// TODO Auto-generated method stub
		return super.getNom();
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getMotDepasse();
	}
	 
	 
	}
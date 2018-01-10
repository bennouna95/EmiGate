package com.emigate.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.emigate.entite.Image;
import com.emigate.entite.Publication;
import com.emigate.entite.Utilisateur;

public interface UtilisateurRepo  extends CrudRepository<Utilisateur, Long> {
   
	public Utilisateur findByEmail(String email);
    
    @Query("select user from Utilisateur user where user.email=?1")
	Utilisateur TrouverUserParEmail(String email);
    
}


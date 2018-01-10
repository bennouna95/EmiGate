package com.emigate.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emigate.entite.Utilisateur;

public interface UtilisateurRepository extends  JpaRepository<Utilisateur,Long> {
	
	@Query("select user from Utilisateur user where user.email=?1")
	Utilisateur TrouverUserParEmail(String email);
	
	@Query("select user from Utilisateur user where user.id=?1")
	Utilisateur TrouverUserParId(Long id);
		
	@Modifying
	@Query("update Utilisateur u set u.img = ?1 where u.id=?2")
	void ModifierImage( String image,Long id);
	
	@Modifying
	@Query("update Utilisateur u set  u.genie=?1, u.adresse=?2 ,u.tel=?3  where u.id=?4")
	void ModifierPersoInfo(String genie, String adresse, String tel, Long id);
		
	
	@Query("select c from Friendrequest c join c.utilisateur a where (c.user_id_one = :id and c.status=:status )")
	 Set<Utilisateur> TrouverAmisbyById(@Param("id") int id,@Param("status") int status);
	
	@Query("SELECT p FROM Utilisateur p WHERE p.prenom  like %:rech% or p.nom like %:rech% or p.genie like %:rech% or p.adresse like %:rech%")
	List<Utilisateur> chercherUtilisateur(@Param("rech") String rech);
	@Query("SELECT p FROM Utilisateur p WHERE  p.nom like %:rech% ")
	List<Utilisateur> chercherNom(@Param("rech") String rech);
	@Query("SELECT p FROM Utilisateur p WHERE p.prenom  like %:rech% ")
	List<Utilisateur> chercherPrenom(@Param("rech") String rech);
	@Query("SELECT p FROM Utilisateur p WHERE  p.adresse like %:rech%")
	List<Utilisateur> chercherAdresse(@Param("rech") String rech);
	@Query("SELECT p FROM Utilisateur p WHERE p.tel = :rech ")
	List<Utilisateur> chercherTel(@Param("rech") String rech);
	@Query("SELECT p FROM Utilisateur p WHERE p.genie like %:rech% ")
	List<Utilisateur> chercherGenie(@Param("rech") String rech);
	
	
}


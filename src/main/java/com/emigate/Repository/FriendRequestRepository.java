package com.emigate.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emigate.entite.Friendrequest;
import com.emigate.entite.Utilisateur;

public interface FriendRequestRepository extends JpaRepository<Friendrequest,Long> {
		
	@Modifying
	@Query("update Friendrequest SET status = ?1  WHERE user_id_one = ?2 AND user_id_two = ?3 ")
	void accepter(int status,Long id1, Long id2);
	

	@Modifying
	@Query("update Friendrequest SET status = ?1  WHERE user_id_one = ?2 AND user_id_two= ?3 ")
	void refuser(int status,Long id1, Long id2);

	
	@Modifying
	@Query("update Friendrequest SET status = ?1  WHERE user_id_one = ?2 AND user_id_two = ?3 ")
	void allrequests(Long id);

	
	// @Query("Select Utilisateur.user_id,Utilisateur.nom, Utilisateur.email, Utilisateur.password  from Friendrequest,Utilisateur WHERE Friendrequest.user_one_id=Utilisateur.user_id AND user_two_id = ?1 and status = ?2")
	// @Query("select c from CercleAmis c join c.utilisateur a where (a.user_id_one = :id)")

	// Set<Utilisateur> AllFriends(Long id2,int status);
	 
	//  @Query("Select u from Utilisateur  c join c.cv a where (a.id = :id)")
	 
	 
	 @Query("select c from Friendrequest c where (c.user_id_one=?1 or c.user_id_two=?1) and c.status=?2  ")
	 List<Friendrequest> TrouverFRById(@Param("id") Long id,@Param("status") int status);
	 
	 @Query("select c from Friendrequest c where (c.user_id_two=?1) and c.status=?2  ")
	 List<Friendrequest> TrouverRById(@Param("id") Long id,@Param("status") int status);

	 
	 @Query("select c from Friendrequest c where (c.user_id_one=?1 and c.user_id_two=?2) or (c.user_id_one=?2 and c.user_id_two=?1) ")
	 Friendrequest EstAmi( Long id1, Long id2);
	 
	 @Query("select c from Friendrequest c where ((c.user_id_one=?1 and c.user_id_two=?2) and c.status=0) or ((c.user_id_one=?2 and c.user_id_two=?1) and c.status=0) ")
	 Friendrequest EstAttenteAmi(Long id1, Long id2);

}

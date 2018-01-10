package com.emigate.Repository;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emigate.entite.Notifications;

public interface NotificationRepo extends JpaRepository<Notifications,Long> {
		
	@Query("SELECT n FROM Notifications n INNER JOIN n.UtilisateurList users WHERE users.id=:id")
	List<Notifications> GetNotificationsByUserId(@Param("id") Long id);	
}

 
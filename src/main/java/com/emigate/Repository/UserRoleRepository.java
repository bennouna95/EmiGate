package com.emigate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.emigate.entite.users_role;

public interface UserRoleRepository extends JpaRepository<users_role,Long> {
	
	
	@Modifying
	@Query("update users_role ur set ur.username = ?1  where ur.id = ?2")
	void ModifierUsersRole(String username, Long id);


}

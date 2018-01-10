package com.emigate.Repository;

import java.util.Set;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emigate.entite.Education;
import com.emigate.entite.Langue;

public interface LangueRepository extends JpaRepository<Langue,Long> {
	
	@Modifying
	@Query("update Langue c set c.langue = ?1, c.niveau = ?2  where c.id = ?3")
	void ModifierLangue( String langue, int niveau,Long id);

	
	@Query("select l from Langue  l join l.cv a where (a.id = :id)")
	Set<Langue> TrouverLanguebyByCvId(@Param("id") Long id);
}

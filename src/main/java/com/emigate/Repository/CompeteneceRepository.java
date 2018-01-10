package com.emigate.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emigate.entite.Competence;

public interface CompeteneceRepository extends  JpaRepository<Competence,Long> {
	
	@Modifying
	@Query("update Competence c set c.competence = ?1, c.niveau = ?2   where c.id = ?3")
	void ModifierCompetence( String competence, int niveau,Long id);
		
    @Query("select c from Competence  c join c.cv a where (a.id = :id)")
	Set<Competence> TrouverCompetncebyByCvId(@Param("id") Long id);
	 

}

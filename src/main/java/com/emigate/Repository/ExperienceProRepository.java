package com.emigate.Repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emigate.entite.Competence;
import com.emigate.entite.ExperiencePro;
 
public interface ExperienceProRepository extends JpaRepository<ExperiencePro,Long>  {
	
	
	@Modifying
	@Query("update ExperiencePro e set e.titre = ?1, e.dateDebut = ?2, e.dateFin = ?3,e.description= ?4  where e.id = ?5")
	void ModifierExp( String  titre, String dateDebut, String dateFin, String description,Long id);

	
	@Query("select e from ExperiencePro  e join e.cv a where (a.id = :id)")
	 Set<ExperiencePro> TrouverExpByCvId(@Param("id") Long id);


}

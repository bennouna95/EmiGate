package com.emigate.Repository;

import java.util.Date;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emigate.entite.Competence;
import com.emigate.entite.Education;
 
public interface EducationRepository extends JpaRepository<Education,Long>  {
	
	@Modifying
	@Query("update Education e set e.ecole = ?1, e.dateDebut = ?2, e.dateFin = ?3,e.diplome= ?4  where e.Id = ?5")
	void ModifierEducation( String ecole,String dateDebut, String dateFin, String diplome,Long id);
	
	
	 @Query("select e from Education  e join e.cv a where (a.id = :id)")
		Set<Education> TrouverEducationbyByCvId(@Param("id") Long id);
}

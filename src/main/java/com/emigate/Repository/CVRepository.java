package com.emigate.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emigate.entite.CV;


public interface CVRepository extends JpaRepository<CV,Long> {
	
	 @Query("select c from CV c  where c.id = :id")
	 CV TrouverCvByCvId(@Param("id") Long id);
	 
	
	

}

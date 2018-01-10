package com.emigate.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emigate.entite.Education;
import com.emigate.entite.Langue;
import com.emigate.entite.Publication;


public interface PublicationRepo extends JpaRepository<Publication, Long> {
	@Query("SELECT p FROM Publication p ORDER BY p.id DESC")
	List<Publication> findLatest5Posts(Pageable pageable);
	

    @Query("select p from Publication  p join p.author a where (a.id = :id)")
    List<Publication> TrouverPublicationbyByCvId(@Param("id") Long id);
    
    
	 
}

package com.emigate.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emigate.entite.Publication;

public interface PublicationRepository extends  JpaRepository<Publication,Long>{

	//@Query("SELECT p FROM Publication p WHERE p.nom like :rech or p.prenom like :rech")
	@Query("SELECT p FROM Publication p WHERE p.title like %:rech% or p.body like %:rech%")
	List<Publication> chercherPublication(@Param("rech") String rech);
	@Query("SELECT p FROM Publication p WHERE p.title like %:rech% ")
	List<Publication> chercherTitle(@Param("rech") String rech);
	@Query("SELECT p FROM Publication p WHERE  p.body like %:rech%")
	List<Publication> chercherBody(@Param("rech") String rech);
	
}

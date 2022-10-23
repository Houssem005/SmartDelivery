package com.esprit.microservice.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.microservice.Entity.Reclamation;

public interface ReclamationRepository  extends CrudRepository<Reclamation, Long>{
	
	  @Query("SELECT r from Reclamation r where r.titre like :x")
	    List<Reclamation> retrieveBytitre(@Param("x") String x);
	  
	  @Query("SELECT r from Reclamation r order by r.date desc ")
	    List<Reclamation> retriveReclamationPriceDesc();

	    @Query("SELECT r from Reclamation r order by r.date asc ")
	    List<Reclamation> retriveReclamationPriceAsc();


}

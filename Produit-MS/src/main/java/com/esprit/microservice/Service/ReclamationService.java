package com.esprit.microservice.Service;

import java.util.List;

import com.esprit.microservice.Entity.Reclamation;



public interface ReclamationService {
	 //affiche
		List<Reclamation> retrieveAllReclamations();
	      //ajout
		Reclamation addReclamation(Reclamation f);
		//delete
		void deleteReclamation(Long id);
	     //mofifier
		Reclamation updateReclamation(Reclamation f);
	      //recherche par id
		Reclamation retrieveReclamation(Long id);
		//recherche par titre
				List<Reclamation> retrieveBytitre(String x);

				List<Reclamation> retriveReclamationPriceDesc();
				List<Reclamation> retriveReclamationPriceAsc();


}


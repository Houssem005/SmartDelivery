package com.esprit.microservice.Controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.esprit.microservice.Service.ReclamationService;


import com.esprit.microservice.Entity.Reclamation;


@RestController
@RequestMapping("/reclamation")
public class ReclamationRestController {
	@Autowired
	ReclamationService ReclamationService;
	 // http://localhost:8081/reclamation/reclamations
	 @GetMapping("/reclamations")
	 public List<Reclamation> getReclamations() {
	 List<Reclamation> listReclamations =ReclamationService.retrieveAllReclamations();
	 return listReclamations;
	 }
	// http://localhost:8081/SpringMVC/reclamation/retrieve-reclamation/8
		 @GetMapping("/reclamations/{reclamation-id}")

		 public Reclamation retrieveReclamation(@PathVariable("reclamation-id") Long reclamationId) {
		 return ReclamationService.retrieveReclamation(reclamationId);
		 }
		 // http://localhost:8081/SpringMVC/reclamation/add
		 
		 @PostMapping("/add")
			
		 public Reclamation addReclamation(@RequestBody Reclamation f) throws  IOException 
		{
			System.out.println( );
			 Reclamation reclamation = ReclamationService.addReclamation(f);
			 //envoi un mail de reclamation au fournisseur
			 
		 return reclamation;
		 }
		// http://localhost:8081/SpringMVC/reclamation/delete/{reclamation-id}
		 @DeleteMapping("/delete/{reclamation-id}")
		 @ResponseBody
		 public void removeReclamation(@PathVariable("reclamation-id") Long reclamationId) {
			 ReclamationService.deleteReclamation(reclamationId);
		 }
		 // http://localhost:8081/SpringMVC/reclamation/modify
		 @PutMapping("/modify")
		 @ResponseBody
		 public Reclamation modifyReclamation(@RequestBody Reclamation reclamation) {
		 return ReclamationService.updateReclamation(reclamation);
		 }
		 
		

			   
		// http://localhost:8081/SpringMVC/reclamation/retrieve-by-titre/{titre}
		 @GetMapping("/retrieve-by-titre/{titre}")
		 @ResponseBody
		 public List<Reclamation> getBytitre(@PathVariable("titre") String titre) {
		 return ReclamationService.retrieveBytitre(titre);
		 }
		 // http://localhost:8081/SpringMVC/reclamation/retrieve-reclamations-asc
		 @GetMapping("/retrieve-reclamations-asc")
		 @ResponseBody
		 public List<Reclamation> getReclamationAsc() {
		 return ReclamationService.retriveReclamationPriceDesc();
		 }
		// http://localhost:8081/SpringMVC/reclamation/retrieve-reclamations-desc
			 @GetMapping("/retrieve-reclamations-desc")
			 @ResponseBody
			 public List<Reclamation> getReclamationDesc() {
			 return ReclamationService.retriveReclamationPriceAsc();
			 }
}


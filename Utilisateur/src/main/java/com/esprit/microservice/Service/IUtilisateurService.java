package com.esprit.microservice.Service;

import javax.xml.ws.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Utilisateur;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;





public interface IUtilisateurService {

	ResponseEntity<Response> add(MultipartFile file, String Utilisateur)
			throws JsonParseException, JsonMappingException, Exception;
	
	Utilisateur updateUtilisateur(Utilisateur newUtilisateur);
	// ResponseEntity<String> deleteHotel(int id);
	String deleteUtilisateur(int id);
	
}

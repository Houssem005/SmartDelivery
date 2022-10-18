package com.esprit.microservice.Controller;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Utilisateur;
import com.esprit.microservice.Service.IUtilisateurService;

import com.fasterxml.jackson.databind.JsonMappingException;





@RestController
public class UtilisateurRestApi {
	private String title="hello I'm the Utilisateur Microservice";
	

	@Autowired
	IUtilisateurService UtilisateurService; 

	
	
	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<Response>  addUtilisateur(@RequestPart("file") MultipartFile file,@RequestParam("Utilisateur") String s)throws JsonParseException, JsonMappingException, Exception {
		 return UtilisateurService.add(file,s);
	}
	
	@PutMapping("/update-Utilisateur/{id}")
	@ResponseBody
	Utilisateur updateUtilisateur(@RequestBody Utilisateur s){
		return UtilisateurService.updateUtilisateur(s);
	}
	
	
	
	@RequestMapping("/hello")
	
	public String sayHello(){
		
		System.out.println(title);
		return title;
	}
	
	@DeleteMapping(value="/id", produces= MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteUtilisateur(@PathVariable(value="id") int  id){
	return new ResponseEntity<>(UtilisateurService.deleteUtilisateur(id),HttpStatus.OK);

	}
}

package com.esprit.microservice.Service;

import java.io.File;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.xml.ws.Response;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.omg.CORBA.IntHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.esprit.microservice.Entity.Utilisateur;
import com.esprit.microservice.Repository.UtilisateurRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;







@Service
public class UtilisateurService implements IUtilisateurService {

	
	@Autowired
	private UtilisateurRepository utilisateurRepository; 
	@Autowired
    ServletContext context;
	
	@Override
    public ResponseEntity<Response> add(MultipartFile file, String Utilisateur) throws JsonParseException, JsonMappingException, Exception
    {

        System.out.println("Ok .............");
        Utilisateur s = new ObjectMapper().readValue(Utilisateur, Utilisateur.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mkdir success.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }


        s.setImage(newFileName);

        Utilisateur art = utilisateurRepository.save(s);



        if (art != null)
        {
            return new ResponseEntity<Response>( HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response>(HttpStatus.BAD_REQUEST);
        }



    }

	public Utilisateur updateUtilisateur(Utilisateur newUtilisateur) {
			 return (utilisateurRepository.save(newUtilisateur));
			
	

}
	
	
	public String deleteUtilisateur(int id) {
		if (utilisateurRepository.findById(id).isPresent()) {
			utilisateurRepository.deleteById(id);
			return "Utilisateur supprimé";
} else
return "Utilisateur non supprimé";
	}
	
	
	
	
	
	
}

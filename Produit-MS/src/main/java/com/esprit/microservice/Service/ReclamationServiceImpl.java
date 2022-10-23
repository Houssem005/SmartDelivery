package com.esprit.microservice.Service;


import java.util.List;

import javax.transaction.Transactional;
import com.esprit.microservice.Repository.ReclamationRepository;
import com.esprit.microservice.Entity.Reclamation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReclamationServiceImpl implements ReclamationService{
	
	@Autowired
	ReclamationRepository ReclamationRepository;
	
    @Override
	public List<Reclamation> retrieveAllReclamations() {
    List<Reclamation> reclamations = (List<Reclamation>) ReclamationRepository.findAll();
		
		for(Reclamation reclamation : reclamations){
	System.out.println("reclamation +++ :" +reclamation);
		}
		
		return reclamations;
	}

@Override

public Reclamation addReclamation(Reclamation f) {
ReclamationRepository.save(f);
// f.setFournisseur(FournisseurRepository.findById(idFournisseur).get());
	 return f;
}

	@Override
	public void deleteReclamation(Long id) {
		ReclamationRepository.delete(ReclamationRepository.findById(id).get());
		
	}

	@Override
	public Reclamation updateReclamation(Reclamation f) {
		return ReclamationRepository.save(f);
	}

	@Override
	@Transactional
	public Reclamation retrieveReclamation(Long id) {
		Reclamation reclamation = ReclamationRepository.findById(id).get();

		return reclamation;
	}
	@Override
	public List<Reclamation> retrieveBytitre(String x){
		List<Reclamation> resclamations = (List<Reclamation>) ReclamationRepository.retrieveBytitre(x);
		return resclamations ;
	} 
	@Override 
	public List<Reclamation> retriveReclamationPriceDesc(){
		List<Reclamation> resclamations = (List<Reclamation>) ReclamationRepository.retriveReclamationPriceDesc();
		return resclamations ;
	} 
	@Override 
	public List<Reclamation> retriveReclamationPriceAsc(){
		List<Reclamation> resclamations = (List<Reclamation>) ReclamationRepository.retriveReclamationPriceAsc();
		return resclamations ;
	} 

}


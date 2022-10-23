package com.esprit.Produit.Service;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.Produit.Entity.Produit;
import com.esprit.Produit.Repository.ProduitRepository;

@Service
public class ProduitService  implements IProduitService {
	@Autowired
	ProduitRepository produitRepository;

	@Override
	public List<Produit> retrieveAllProduits() {
		List<Produit> produits = (List<Produit>) produitRepository.findAll();
		
		for(Produit produit : produits){
	System.out.println("produit +++ :" +produit);
		}
		
		return produits;
	
	}

	@Override
	public Produit addProduit(Produit p) {
		
		return produitRepository.save(p);
		
	}

	
	@Override
	public Produit retrieveProduit(Long id) {
		Produit produit = produitRepository.findById(id).get();
		return produit;
		
	}
	@Override
	public void deleteProduit(Long id) {
		produitRepository.deleteById(id);
	
	}
	

	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}
	}

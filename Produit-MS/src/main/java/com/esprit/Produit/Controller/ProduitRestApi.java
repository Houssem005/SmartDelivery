package com.esprit.Produit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.Produit.Entity.Produit;
import com.esprit.Produit.Service.IProduitService;
import com.esprit.Produit.Service.ProduitService;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/produit")
public class ProduitRestApi {
	
	@Autowired
	ProduitService produitService;
	 // http://localhost:8081/SpringMVC/produit/retrieve-all-produits
	 @GetMapping("/retrieve-all-produits")
	 public List<Produit> getproduits() {
	 List<Produit> listproduits = produitService.retrieveAllProduits();
	 return listproduits;
	 }
	// http://localhost:8081/SpringMVC/produit/retrieve-produit/8
	 @GetMapping("/retrieve-produit/{produit-id}")

	 public Produit retrieveproduit(@PathVariable("produit-id") Long produitId) {
	 return produitService.retrieveProduit(produitId);
	 }
	 // http://localhost:8081/SpringMVC/produit/add-produit
	 @PostMapping("/add-produit")
	
	 public Produit addproduit(@RequestBody Produit p) 
	{
	 Produit produit = produitService.addProduit(p);
	 return produit;
	 }
	// http://localhost:8081/SpringMVC/produit/remove-produit/{produit-id}
	 @DeleteMapping("/remove-produit/{produit-id}")
	 @ResponseBody
	 public void removeproduit(@PathVariable("produit-id") Long produitId) {
	 produitService.deleteProduit(produitId);
	 }
	 // http://localhost:8081/SpringMVC/produit/modify-produit
	 @PutMapping("/modify-produit")
	 @ResponseBody
	 public Produit modifyproduit(@RequestBody Produit produit) {
	 return produitService.updateProduit(produit);
	 }
	
}

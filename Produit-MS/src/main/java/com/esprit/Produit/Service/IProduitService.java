package com.esprit.Produit.Service;

import java.util.List;
import com.esprit.Produit.Entity.Produit;



public interface IProduitService {

	List<Produit> retrieveAllProduits();
	Produit addProduit(Produit p);
	Produit retrieveProduit(Long id);
	void deleteProduit(Long id);
	Produit updateProduit(Produit p);

}

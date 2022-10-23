package com.esprit.Produit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.Produit.Entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository <Produit,Long> {
	List<Produit> findAll();
	

}

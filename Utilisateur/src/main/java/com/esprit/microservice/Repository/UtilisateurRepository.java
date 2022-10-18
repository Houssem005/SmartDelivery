package com.esprit.microservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.microservice.Entity.Utilisateur;

public interface UtilisateurRepository  extends JpaRepository <Utilisateur,Integer>{

}

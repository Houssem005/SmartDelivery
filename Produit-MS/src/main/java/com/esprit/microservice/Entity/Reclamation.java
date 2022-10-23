package com.esprit.microservice.Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;



@SuppressWarnings("serial")
@Entity
@Table(name = "Reclamation")
public class Reclamation  implements Serializable{
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idReclamation")
	private long idReclamation;
    @Column(name="titre")
	private String titre;
	@Column(name="description")
	private String description;
	@Column(name="date")
	private Date date;
	
	
	public long getIdReclamation() {
		return idReclamation;
	}
	public void setIdReclamation(long idReclamation) {
		this.idReclamation = idReclamation;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Reclamation(long idReclamation, String titre, String description, Date date) {
		super();
		this.idReclamation = idReclamation;
		this.titre = titre;
		this.description = description;
		this.date = date;
		
	}
	public Reclamation() {
		super();
	} 
	

	
}


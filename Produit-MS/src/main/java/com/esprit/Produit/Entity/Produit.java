package com.esprit.Produit.Entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@SuppressWarnings("serial")
@Entity
@Table(name = "Produit")
public class Produit implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idProduit")
	private long idProduit;
	@Column(name="codeProduit")
	private String codeProduit;
	@Column(name="libelleProduit")
	private String libelleProduit;
	@Column(name="prixUnitaire")
	private float prixUnitaire;
 
	
		public Produit(){};
	

	public Produit(long idProduit, String codeProduit, String libelleProduit, float prixUnitaire)

			{
		super();
		this.idProduit = idProduit;
		this.codeProduit = codeProduit;
		this.libelleProduit = libelleProduit;
		this.prixUnitaire = prixUnitaire;
	
	}

	
	
	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getCodeProduit() {
		return codeProduit;
	}

	public void setCodeProduit(String codeProduit) {
		this.codeProduit = codeProduit;
	}

	public String getLibelleProduit() {
		return libelleProduit;
	}

	public void setLibelleProduit(String libelleProduit) {
		this.libelleProduit = libelleProduit;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}





	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", codeProduit=" + codeProduit + ", libelleProduit=" + libelleProduit

				+ ", prixUnitaire=" + prixUnitaire + "]";

	}
	
	
	
	
	

}
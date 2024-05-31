
package com.etm.tp.model;

import java.io.Serializable;




import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;

	
	
@jakarta.persistence.Entity
@jakarta.persistence.Table(schema = "spring_angular_projet", name = "Compte")

@JsonDeserialize(as = Compte.class)

public class Compte implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final boolean False = false;

	@jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int compte_id;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 255)
    private String prenom;

    @Column(name = "genre", nullable = false, length = 1)
    private String genre;
    
    @Column(name = "date_naissance", nullable = false, length = 255)
    private String date_naissance;


//    @jakarta.persistence.Temporal(jakarta.persistence.TemporalType.DATE)
//    @DateTimeFormat(pattern = "dd/mm/yyyy")
//    private LocalDate date_naissance;
    
	@Column(name = "telephone", nullable = false, length = 255)
    private int telephone;

    @Column(name = "adresse", nullable = false, length = 255)
    private String adresse;

    @OneToOne(mappedBy = "compte")
    //@jakarta.persistence.JoinColumn(name = "employe", nullable = false)
	private Employe employe;
    
	
    
    //////////////////////////////////////

    public int getCompte_id() {
		return compte_id;
	}

	public void setCompte_id(int compte_id) {
		this.compte_id = compte_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}

//	public String getDatenaissance() {
//		return datenaissance;
//	}
//
//	public void setDatenaissance(String datenaissance) {
//		this.datenaissance = datenaissance;
//	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	
	
	public Compte(int compte_id, String nom, String prenom, String genre, String date_naissance, int telephone,
			String adresse, Employe employe) {
		super();
		this.compte_id = compte_id;
		this.nom = nom;
		this.prenom = prenom;
		this.genre = genre;
		this.date_naissance = date_naissance;
		this.telephone = telephone;
		this.adresse = adresse;
		this.employe = employe;

	}

	
	public Compte() {
	
	}


    ////////////////////////////////////
    


}


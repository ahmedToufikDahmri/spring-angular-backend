
package com.etm.tp.model;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;

	
@jakarta.persistence.Entity
@jakarta.persistence.Table(schema = "spring_angular_projet", name = "Departement")
public class Departement implements Serializable {

	private static final long serialVersionUID = 2L;

	@jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int departement_id;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
   
    @OneToMany(mappedBy = "departement")
    @Cascade(CascadeType.ALL)
    @JsonIgnore
	private List<Employe> employe;

	public int getDepartement_id() {
		return departement_id;
	}

	public void setDepartement_id(int departement_id) {
		this.departement_id = departement_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Employe> getEmploye() {
		return employe;
	}

	public void setEmploye(List<Employe> employe) {
		this.employe = employe;
	}
	

	
	@Override
	public String toString() {
		return "Departement [departement_id=" + departement_id + ", nom=" + nom + ", employe=" + employe + "]";
	}

	public Departement() {
		
	}

	public Departement(int departement_id, String nom, List<Employe> employe) {
		super();
		this.departement_id = departement_id;
		this.nom = nom;
		this.employe = employe;
	}


}
		

/*
	@Override
	public String toString() {
		return "Departement [departement_id=" + departement_id + ", nom=" + nom + ", employe=" + employes + "]";
	}
	
	public Departement() {
		
	}

	public Departement(int departement_id, String nom, List<Employe> employes) {
		super();
		this.departement_id = departement_id;
		this.nom = nom;
		this.employes = employes;
	}
	*/
    

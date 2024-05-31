

package com.etm.tp.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;

	
	
@jakarta.persistence.Entity
@jakarta.persistence.Table(schema = "spring_angular_projet", name = "Diplome")
public class Diplome implements Serializable {

	private static final long serialVersionUID = 3L;

	@jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int diplome_id;
	

    @Column(name = "universite", nullable = false, length = 255)
    private String universite;
    
    @Column(name = "annee", nullable = false, length = 255)
    private String annee;
    
    @Column(name = "specialite", nullable = false, length = 255)
    private String specialite;
    
    @ManyToOne(cascade = CascadeType.ALL )
    @jakarta.persistence.JoinColumn(name = "type_diplome", nullable = true)
	private Type_diplome type_diplome;
    
    
    @ManyToOne(cascade = CascadeType.ALL )
    @jakarta.persistence.JoinColumn(name = "employe", nullable = true)
	private Employe employe;

	public int getDiplome_id() {
		return diplome_id;
	}

	public void setDiplome_id(int diplome_id) {
		this.diplome_id = diplome_id;
	}
	

	public String getUniversite() {
		return universite;
	}

	public void setUniversite(String universite) {
		this.universite = universite;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public Type_diplome getTypeDiplome() {
		return type_diplome;
	}

	public void setTypeDiplome(Type_diplome type_diplome) {
		this.type_diplome = type_diplome;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Diplome(int diplome_id, String universite, String annee, String specialite, Type_diplome type_diplome,
			Employe employe) {
		super();
		this.diplome_id = diplome_id;
		this.universite = universite;
		this.annee = annee;
		this.specialite = specialite;
		this.type_diplome = type_diplome;
		this.employe = employe;
	}
	
	public Diplome() {}
		
	

	@Override
	public String toString() {
		return "Diplome [diplome_id=" + diplome_id + ", universite=" + universite + ", annee=" + annee + ", specialite=" + specialite
				+ ", type_diplome=" + type_diplome + ", employe=" + employe + "]";
	}
    
    
}
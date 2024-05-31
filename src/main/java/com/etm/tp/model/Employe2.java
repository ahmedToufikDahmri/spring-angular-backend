/**

package com.etm.tp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.JoinColumn;



import jakarta.persistence.Column;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


	
@jakarta.persistence.Entity
@jakarta.persistence.Table(schema = "spring_angular_m16", name = "Employe2")
public class Employe2 implements Serializable {

	private static final long serialVersionUID = -3415388341943341473L;

	@jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int employe_id;

    @Column(name = "poste", nullable = false, length = 255)
    private String poste;

    @OneToOne()
    @jakarta.persistence.JoinColumn(name = "compte", nullable = false)
	private Compte compte;
    
    @OneToMany(mappedBy = "employe")
	private List<Diplome> diplome;
    
    @ManyToOne()
    @jakarta.persistence.JoinColumn(name = "departement_id", nullable = false)
	private Departement departement;
    
    
    @ManyToMany
    @JoinTable( name = "Employe_Mission",
                joinColumns = @JoinColumn( name = "Employe_id",nullable = false ),
                inverseJoinColumns = @JoinColumn( name = "Mission_id" ) )
    private List<Mission> mission = new ArrayList<>();
    

    
    //////////////////////////////////////


	
	
	public Employe2(int employe_id, String poste, Compte compte, List<Diplome> diplome, Departement departement,
			List<Mission> mission) {
		super();
		this.employe_id = employe_id;
		this.poste = poste;
		this.compte = compte;
		this.diplome = diplome;
		this.departement = departement;
		this.mission = mission;
	}
	
	
	  ////////////////////////////////////
	
	public int getEmploye_id() {
		return employe_id;
	}

	public void setEmploye_id(int employe_id) {
		this.employe_id = employe_id;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public List<Diplome> getDiplome() {
		return diplome;
	}

	public void setDiplome(List<Diplome> diplome) {
		this.diplome = diplome;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public List<Mission> getMission() {
		return mission;
	}

	public void setMission(List<Mission> mission) {
		this.mission = mission;
	}

	public Employe2() {
		
	}

	@Override
	public String toString() {
		return "Employe [employe_id=" + employe_id + ", poste=" + poste + ", compte=" + compte + ", diplome=" + diplome
				+ ", departement=" + departement + ", mission=" + mission + "]";
	}







}

*/

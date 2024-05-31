package com.etm.tp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

	
	
@jakarta.persistence.Entity
@jakarta.persistence.Table(schema = "spring_angular_projet", name = "Employe")

@JsonDeserialize(as = Employe.class)

public class Employe implements Serializable {

	private static final long serialVersionUID = 4L;

	//private static final String "compte_id", refrenceColomnName  = null;

	@jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int employe_id;

    @Column(name = "poste", nullable = false, length = 255)
    private String poste;
    

     // @Column(name = "compte", nullable = false, length = 255)
    //  private int compte;
    
    // @Column(name = "departement_id", nullable = true, length = 255)
    //private int departement_id;
    
    
    @OneToOne(cascade = CascadeType.ALL )
    @JsonIgnore
    @JoinColumn(name = "compte", referencedColumnName = "compte_id",nullable = true)
 //   @jakarta.persistence.JoinColumn(name = "compte", nullable = true)
	private Compte compte;
      

   
   //   @ManyToOne(fetch= FetchType.LAZY,cascade=persist, appedBy="parent")
  //  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    // @jakarta.persistence.JoinColumn(name = "departement", nullable = false)
    
    
    @ManyToOne(fetch= FetchType.LAZY )
    @JsonIgnore
    @JoinColumn(name = "departement", referencedColumnName = "departement_id",nullable = true)
	private Departement departement;

    @OneToMany(mappedBy = "employe")
    @JsonIgnore
	private List<Diplome> diplome;
    
    @ManyToMany
    @JsonIgnore
    @JoinTable( name = "employe_mission",
                joinColumns = @JoinColumn( name = "Mission_id",  nullable = true),
                inverseJoinColumns = @JoinColumn( name = "Employe_id" ) )
    private List<Mission> mission = new ArrayList<>();

    
    
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
	
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	public List<Diplome> getDiplome() {
		return diplome;
	}

	public void setDiplome(List<Diplome> diplome) {
		this.diplome = diplome;
	}
	
	public List<Mission> getMission() {
		return mission;
	}

	public void setMission(List<Mission> mission) {
		this.mission = mission;
	}
	


	@Override
	public String toString() {
		return "Employe [employe_id=" + employe_id + ", poste=" + poste + ", compte=" + compte + ", departement="
				+ departement + ", diplome=" + diplome + ", mission=" + mission + "]";
	}

	
	public Employe(int employe_id, String poste, Compte compte, Departement departement, List<Diplome> diplome,
			List<Mission> mission) {
		super();
		this.employe_id = employe_id;
		this.poste = poste;
		this.compte = compte;
		this.departement = departement;
		this.diplome = diplome;
		this.mission = mission;
	}

	public Employe() {}


    


    
    //////////////////////////////////////



	

    
    

  
    
	
	


}


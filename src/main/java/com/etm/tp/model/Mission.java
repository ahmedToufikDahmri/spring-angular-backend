package com.etm.tp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import jakarta.persistence.JoinColumn;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;



@jakarta.persistence.Entity
@jakarta.persistence.Table(schema = "spring_angular_projet", name = "Mission")
public class Mission implements Serializable {

	private static final long serialVersionUID = 5L;

	@jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int mission_id;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
    
    
    @Column(name = "date", nullable = true)
    @jakarta.persistence.Temporal(jakarta.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;
    

    @ManyToMany
    @JsonIgnore
    @JoinTable( name = "employe_mission",
                joinColumns = @JoinColumn( name = "Employe_id" ),
                inverseJoinColumns = @JoinColumn( name = "Mission_id" ) )
    @Column(name = "employe", nullable = false)
    private List<Employe> employe = new ArrayList<>();


	@Column(name = "description", nullable = true, length = 500)
    private String description;
    
    //////////////////////////////////////
    
    
    public Mission(int mission_id, String nom, Date date,List<Employe> employe, String description) {
		super();
		this.mission_id = mission_id;
		this.nom = nom;
		this.date = date;
		this.employe = employe;
		this.description = description;

	}


    
    //////////////////////////////
    
    public Mission() {

	}



	public int getMission_id() {
		return mission_id;
	}

	public void setMission_id(int mission_id) {
		this.mission_id = mission_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setEmploye(List<Employe> employe) {
		this.employe = employe;
	}
	
	public List<Employe> getEmploye() {
		return employe;
	}

	public void setDescription(String description) {
		this.description = description;
	}

    

    
}

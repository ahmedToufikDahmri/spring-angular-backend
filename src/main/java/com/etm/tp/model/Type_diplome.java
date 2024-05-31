
package com.etm.tp.model;

import java.io.Serializable;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;


	
	
@jakarta.persistence.Entity
@jakarta.persistence.Table(schema = "spring_angular_projet", name = "Type_diplome")
@JsonDeserialize(as = Type_diplome.class)

public class Type_diplome implements Serializable {

	private static final long serialVersionUID = 6L;

	@jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int type_diplome_id;
	
    @Column(name = "type", nullable = false, length = 255)
	private String type;
	
	
	
	public int getType_diplome_id() {
		return type_diplome_id;
	}
	public void setType_diplome_id(int type_diplome_id) {
		this.type_diplome_id = type_diplome_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;		
	}
	
	public Type_diplome(int type_diplome_id, String type) {
		super();
		this.type_diplome_id = type_diplome_id;
		this.type = type;
	}
	
	public Type_diplome() {

	}
	
	@Override
	public String toString() {
		return "Type_diplome [type_diplome_id=" + type_diplome_id + ", type=" + type + "]";
	}



	
	
	


	
	
}

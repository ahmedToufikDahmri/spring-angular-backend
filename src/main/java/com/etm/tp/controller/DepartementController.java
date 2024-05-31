package com.etm.tp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etm.tp.dao.DepartementRepository;
import com.etm.tp.model.Departement;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class DepartementController {

		
	@Autowired
	private DepartementRepository departementRepository;
	
	// Sélectionner tout les departements
	
	@GetMapping("/departements")
	public List<Departement> getAllDepartements(){
		return departementRepository.findAll();
	}

	// Cree un departement
	@PostMapping("/departements")
	public Departement creeDepartement(@RequestBody Departement departement) {
	return departementRepository.save(departement);
}
	
	// Afficher departement by id rest api
	@GetMapping("/departements/{id}")
	public ResponseEntity<Departement> getDepartementById(@PathVariable int id) {
		Departement departement = null;
		try {
			departement = departementRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Departement not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(departement);
	}
	
	// Modifier departement rest api
	
	@PutMapping("/departements/{id}")
	public ResponseEntity<Departement> updateDepartement(@PathVariable int id, @RequestBody Departement departementDetails){
		Departement departement = null;
		try {
			departement = departementRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Departement not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		departement.setNom(departementDetails.getNom());
		departement.setDepartement_id(departementDetails.getDepartement_id());
		
		Departement updatedDepartement = departementRepository.save(departement);
		return ResponseEntity.ok(updatedDepartement);
	}
	

	
	// Delete departement rest api
	@DeleteMapping("/departements/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDepartement(@PathVariable int id){
		Departement departement = null;
		try {
			 departement = departementRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Departement not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		departementRepository.delete(departement);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

package com.etm.tp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

import com.etm.tp.dao.EmployeRepository;
import com.etm.tp.model.Departement;
import com.etm.tp.model.Employe;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class EmployeController {

		
	@Autowired
	private EmployeRepository employeRepository;
	
	// Sélectionner tout les employes
	
	@GetMapping("/employes")
	public List<Employe> getAllEmployes(){
		return employeRepository.findAll();
	}

	// Cree un employe
	@PostMapping("/employes")
	public Employe creeEmploye(@RequestBody Employe employe) {

	return employeRepository.save(employe);
}
	
	// Afficher employe by id rest api
	@GetMapping("/employes/{id}")
	public ResponseEntity<Employe> getEmployeById(@PathVariable int id) {
		Employe employe = null;
		try {
			employe = employeRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Employe not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(employe);
	}
	
	// Modifier employe rest api
	
	@PutMapping("/employes/{id}")
	public ResponseEntity<Employe> updateEmploye(@PathVariable int id, @RequestBody Employe employeDetails){
		Employe employe = null;
		try {
			employe = employeRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Employe not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		employe.setEmploye_id(employeDetails.getEmploye_id());
		employe.setPoste(employeDetails.getPoste());
		employe.setCompte(employeDetails.getCompte());
		employe.setDepartement(employeDetails.getDepartement());
		
		Employe updatedEmploye = employeRepository.save(employe);
		return ResponseEntity.ok(updatedEmploye);
	}
	

	
	// Delete employe rest api
	@DeleteMapping("/employes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmploye(@PathVariable int id){
		Employe employe = null;
		try {
			 employe = employeRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Employe not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		employeRepository.delete(employe);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

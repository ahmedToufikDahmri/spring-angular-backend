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

import com.etm.tp.dao.CompteRepository;
import com.etm.tp.model.Compte;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class CompteController {

		
	@Autowired
	private CompteRepository compteRepository;
	
	// Sélectionner tout les comptes
	
	@GetMapping("/comptes")
	public List<Compte> getAllComptes(){
		return compteRepository.findAll();
	}

	// Cree un compte
	@PostMapping("/comptes")
	public Compte creeCompte(@RequestBody Compte compte) {
	return compteRepository.save(compte);
}
	
	// Afficher compte by id rest api
	@GetMapping("/comptes/{id}")
	public ResponseEntity<Compte> getCompteById(@PathVariable int id) {
		Compte compte = null;
		try {
			compte = compteRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Compte not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(compte);
	}
	
	// Modifier compte rest api
	
	@PutMapping("/comptes/{id}")
	public ResponseEntity<Compte> updateCompte(@PathVariable int id, @RequestBody Compte compteDetails){
		Compte compte = null;
		try {
			compte = compteRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Compte not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		compte.setCompte_id(compteDetails.getCompte_id());
		compte.setNom(compteDetails.getNom());
		compte.setPrenom(compteDetails.getPrenom());
		compte.setGenre(compteDetails.getGenre());
		compte.setDate_naissance(compteDetails.getDate_naissance());
		compte.setTelephone(compteDetails.getTelephone());
		compte.setAdresse(compteDetails.getAdresse());

		Compte updatedCompte = compteRepository.save(compte);
		return ResponseEntity.ok(updatedCompte);
	}
	


    
	
	
	
	
	// Delete compte rest api
	@DeleteMapping("/comptes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCompte(@PathVariable int id){
		Compte compte = null;
		try {
			 compte = compteRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Compte not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		compteRepository.delete(compte);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

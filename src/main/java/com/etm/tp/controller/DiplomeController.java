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

import com.etm.tp.dao.DiplomeRepository;
import com.etm.tp.model.Diplome;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class DiplomeController {

		
	@Autowired
	private DiplomeRepository diplomeRepository;
	
	// Sélectionner tout les diplomes
	
	@GetMapping("/diplomes")
	public List<Diplome> getAllDiplomes(){
		return diplomeRepository.findAll();
	}

	// Cree un diplome
	@PostMapping("/diplomes")
	public Diplome creeDiplome(@RequestBody Diplome diplome) {
	return diplomeRepository.save(diplome);
}
	
	// Afficher diplome by id rest api
	@GetMapping("/diplomes/{id}")
	public ResponseEntity<Diplome> getDiplomeById(@PathVariable int id) {
		Diplome diplome = null;
		try {
			diplome = diplomeRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Diplome not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(diplome);
	}
	
	// Modifier diplome rest api
	
	@PutMapping("/diplomes/{id}")
	public ResponseEntity<Diplome> updateDiplome(@PathVariable int id, @RequestBody Diplome diplomeDetails){
		Diplome diplome = null;
		try {
			diplome = diplomeRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Diplome not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		diplome.setDiplome_id(diplomeDetails.getDiplome_id());
		diplome.setUniversite(diplomeDetails.getUniversite());
		diplome.setAnnee(diplomeDetails.getAnnee());
		diplome.setSpecialite(diplomeDetails.getSpecialite());
		diplome.setTypeDiplome(diplomeDetails.getTypeDiplome());
		diplome.setEmploye(diplomeDetails.getEmploye());

		
		Diplome updatedDiplome = diplomeRepository.save(diplome);
		return ResponseEntity.ok(updatedDiplome);
	}
	
	
	
	// Delete diplome rest api
	@DeleteMapping("/diplomes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDiplome(@PathVariable int id){
		Diplome diplome = null;
		try {
			 diplome = diplomeRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Diplome not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		diplomeRepository.delete(diplome);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

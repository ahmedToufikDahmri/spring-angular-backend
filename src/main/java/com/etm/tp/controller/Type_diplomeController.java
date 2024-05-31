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

import com.etm.tp.dao.TypeDiplomeRepository;
import com.etm.tp.model.Type_diplome;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class Type_diplomeController {

		
	@Autowired
	private TypeDiplomeRepository typediplomeRepository;
	
	// Sélectionner tout les typediplomes
	
	@GetMapping("/type_diplomes")
	public List<Type_diplome> getAllTypeDiplomes(){
		return typediplomeRepository.findAll();
	}

	// Cree un type diplome
	@PostMapping("/type_diplomes")
	public Type_diplome creeTypeDiplome(@RequestBody Type_diplome type_diplome) {
	return typediplomeRepository.save(type_diplome);
}
	
	// Afficher type diplome by id rest api
	@GetMapping("/type_diplomes/{id}")
	public ResponseEntity<Type_diplome> getTypeDiplomeById(@PathVariable int id) {
		Type_diplome typediplome = null;
		try {
			typediplome = typediplomeRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("TypeDiplome not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(typediplome);
	}
	
	// Modifier typediplome rest api
	
	@PutMapping("/type_diplomes/{id}")
	public ResponseEntity<Type_diplome> updateTypeDiplome(@PathVariable int id, @RequestBody Type_diplome typediplomeDetails){
		Type_diplome typediplome = null;
		try {
			typediplome = typediplomeRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("TypeDiplome not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		typediplome.setType_diplome_id(typediplomeDetails.getType_diplome_id());
		typediplome.setType(typediplomeDetails.getType());

		
		Type_diplome updatedTypeDiplome = typediplomeRepository.save(typediplome);
		return ResponseEntity.ok(updatedTypeDiplome);
	}
	

	
	// Delete typediplome rest api
	@DeleteMapping("/type_diplomes/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTypeDiplome(@PathVariable int id){
		Type_diplome typediplome = null;
		try {
			 typediplome = typediplomeRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("TypeDiplome not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		typediplomeRepository.delete(typediplome);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

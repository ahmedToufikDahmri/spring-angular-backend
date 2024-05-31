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

import com.etm.tp.dao.MissionRepository;
import com.etm.tp.model.Mission;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class MissionController {

		
	@Autowired
	private MissionRepository missionRepository;
	
	// Sélectionner tout les missions
	
	@GetMapping("/missions")
	public List<Mission> getAllMissions(){
		return missionRepository.findAll();
	}

	// Cree une Missions
	@PostMapping("/missions")
	public Mission creeMission(@RequestBody Mission mission) {
	return missionRepository.save(mission);
}
	
	// Afficher mission by id rest api
	@GetMapping("/missions/{id}")
	public ResponseEntity<Mission> getMissionById(@PathVariable int id) {
		Mission mission = null;
		try {
			mission = missionRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Mission not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(mission);
	}
	
	// Modifier mission rest api
	
	@PutMapping("/missions/{id}")
	public ResponseEntity<Mission> updateMission(@PathVariable int id, @RequestBody Mission missionDetails){
		Mission mission = null;
		try {
			mission = missionRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Mission not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mission.setMission_id(missionDetails.getMission_id());
		mission.setNom(missionDetails.getNom());


		Mission updatedMission = missionRepository.save(mission);
		return ResponseEntity.ok(updatedMission);
	}
	


    
	
	
	
	
	// Delete mission rest api
	@DeleteMapping("/missions/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMission(@PathVariable int id){
		Mission mission = null;
		try {
			 mission = missionRepository.findById(id)
					.orElseThrow(() -> new AttributeNotFoundException("Mission not exist with id :" + id));
		} catch (AttributeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		missionRepository.delete(mission);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

package com.etm.tp.Business;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.etm.tp.dao.MissionRepository;
import com.etm.tp.model.Mission;


public class MissionService {


	@Autowired
	MissionRepository MissionRepository;

	
	public List<Mission> afficherTousMissions()
	{
	 return MissionRepository.findAll();
	}


	public  Mission afficherMissionAvecId(int id)
	{
		return MissionRepository.findById(id).orElse(null);
	}

	
	public void enregistrerMission(Mission Mission)
	{
		MissionRepository.save(Mission);
	}

	
	public void supprimerMissionAvecId(int id)
	{
		MissionRepository.deleteById(id);
	}
	

}

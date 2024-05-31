package com.etm.tp.Business;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.etm.tp.dao.DiplomeRepository;
import com.etm.tp.model.Diplome;


public class DiplomeService {


	@Autowired
	DiplomeRepository DiplomeRepository;

	
	public List<Diplome> afficherTousDiplomes()
	{
	 return DiplomeRepository.findAll();
	}


	public  Diplome afficherDiplomeAvecId(int id)
	{
		return DiplomeRepository.findById(id).orElse(null);
	}

	
	public void enregistrerDiplome(Diplome Diplome)
	{
		DiplomeRepository.save(Diplome);
	}

	
	public void supprimerDiplomeAvecId(int id)
	{
		DiplomeRepository.deleteById(id);
	}
	

}

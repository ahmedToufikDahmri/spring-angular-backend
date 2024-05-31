package com.etm.tp.Business;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.etm.tp.dao.DepartementRepository;
import com.etm.tp.model.Departement;


public class DepartementService {


	@Autowired
	DepartementRepository DepartementRepository;

	
	public List<Departement> afficherTousDepartements()
	{
	 return DepartementRepository.findAll();
	}


	public  Departement afficherDepartementAvecId(int id)
	{
		return DepartementRepository.findById(id).orElse(null);
	}

	
	public void enregistrerDepartement(Departement Departement)
	{
		DepartementRepository.save(Departement);
	}

	
	public void supprimerDepartementAvecId(int id)
	{
		DepartementRepository.deleteById(id);
	}
	

}

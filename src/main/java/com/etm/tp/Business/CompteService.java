package com.etm.tp.Business;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.etm.tp.dao.CompteRepository;
import com.etm.tp.model.Compte;


public class CompteService {


	@Autowired
	CompteRepository CompteRepository;

	
	public List<Compte> afficherTousComptes()
	{
	 return CompteRepository.findAll();
	}


	public  Compte afficherCompteAvecId(int id)
	{
		return CompteRepository.findById(id).orElse(null);
	}

	
	public void enregistrerCompte(Compte Compte)
	{
		CompteRepository.save(Compte);
	}

	
	public void supprimerCompteAvecId(int id)
	{
		CompteRepository.deleteById(id);
	}
	

}

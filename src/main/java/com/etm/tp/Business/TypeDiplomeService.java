package com.etm.tp.Business;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etm.tp.dao.TypeDiplomeRepository;
import com.etm.tp.model.Type_diplome;


public class TypeDiplomeService {


	@Autowired
	TypeDiplomeRepository TypeDiplomeRepository;

	
	public List<Type_diplome> afficherTousTypeDiplomes()
	{
	 return TypeDiplomeRepository.findAll();
	}


	public  Type_diplome afficherTypeDiplomeAvecId(int id)
	{
		return TypeDiplomeRepository.findById(id).orElse(null);
	}

	
	public void enregistrerTypeDiplome(Type_diplome TypeDiplome)
	{
		TypeDiplomeRepository.save(TypeDiplome);
	}

	
	public void supprimerTypeDiplomeAvecId(int id)
	{
		TypeDiplomeRepository.deleteById(id);
	}
	

}

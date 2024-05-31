package com.etm.tp.Business;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.etm.tp.dao.EmployeRepository;
import com.etm.tp.model.Employe;


public class EmployeService {


	@Autowired
	EmployeRepository EmployeRepository;

	
	public List<Employe> afficherTousEmployes()
	{
	 return EmployeRepository.findAll();
	}


	public  Employe afficherEmployeAvecId(int employe_id)
	{
		return EmployeRepository.findById(employe_id).orElse(null);
	}

	
	public void enregistrerEmploye(Employe Employe)
	{
		EmployeRepository.save(Employe);
	}

	
	public void supprimerEmployeAvecId(int employe_id)
	{
		EmployeRepository.deleteById(employe_id);
	}
	

}

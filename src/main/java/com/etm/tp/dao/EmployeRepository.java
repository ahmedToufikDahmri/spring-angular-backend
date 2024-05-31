
package com.etm.tp.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.etm.tp.model.Employe;

@EnableJpaRepositories
public interface EmployeRepository extends JpaRepository<Employe, Integer> {


}
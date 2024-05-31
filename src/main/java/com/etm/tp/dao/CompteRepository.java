
package com.etm.tp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.etm.tp.model.Compte;

@EnableJpaRepositories
public interface CompteRepository extends JpaRepository<Compte, Integer> {

}


package com.etm.tp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.etm.tp.model.Diplome;

@EnableJpaRepositories
public interface DiplomeRepository extends JpaRepository<Diplome, Integer> {

}
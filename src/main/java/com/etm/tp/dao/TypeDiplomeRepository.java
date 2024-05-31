
package com.etm.tp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.etm.tp.model.Type_diplome;

@EnableJpaRepositories
public interface TypeDiplomeRepository extends JpaRepository<Type_diplome, Integer> {

}
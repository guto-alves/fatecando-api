package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

	List<Institution> findAllByOrderByName();
}

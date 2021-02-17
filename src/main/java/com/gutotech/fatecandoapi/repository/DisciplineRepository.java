package com.gutotech.fatecandoapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long>{

	Optional<Discipline> findAllBySemester(int semester);
}

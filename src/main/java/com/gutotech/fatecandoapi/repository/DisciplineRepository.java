package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Course;
import com.gutotech.fatecandoapi.model.Discipline;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

	List<Discipline> findAllByOrderByName();

	List<Discipline> findAllBySemesterOrderByName(Integer semester);

	List<Discipline> findAllByCourseOrderByName(Course course);
	
	@Query("select distinct d from Discipline d join d.topics t order by d.name")
	List<Discipline> findAllWithTopics();

}

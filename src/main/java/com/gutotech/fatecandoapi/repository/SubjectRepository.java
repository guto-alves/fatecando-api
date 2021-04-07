package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Course;
import com.gutotech.fatecandoapi.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

	List<Subject> findAllByOrderByName();

	List<Subject> findAllBySemesterOrderByName(Integer semester);

	List<Subject> findAllByCourseOrderByName(Course course);

	@Query("select distinct s from Subject s join s.topics t order by s.name")
	List<Subject> findAllWithTopics();

}

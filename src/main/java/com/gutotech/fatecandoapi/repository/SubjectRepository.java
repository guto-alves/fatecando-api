package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

	@Query("select s from Subject s where s.enabled = true order by s.name")
	List<Subject> findEnabledByOrderByName();
	
	@Query("select s from Subject s order by s.name")
	List<Subject> findByOrderByName();

	@Query("select s from Subject s where s.enabled = true and s.semester = ?1 order by s.name")
	List<Subject> findBySemesterOrderByName(Integer semester);

	@Query("select distinct s from Subject s join s.topics t where s.enabled = true order by s.name")
	List<Subject> findWithTopics();

	@Query("select s from Subject s "
			+ "where s.enabled = true and (upper(s.name) like upper(concat('%', ?1, '%')) "
			+ "or upper(s.code) like upper(concat('%', ?1, '%')) "
			+ "or upper(s.description) like upper(concat('%', ?1, '%')) "
			+ "or upper(s.objective) like upper(concat('%', ?1, '%')) "
			+ "or cast(s.semester as text) like ?1)")
	List<Subject> findBy(String text);

}

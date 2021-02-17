package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.ForumTopic;

@Repository
public interface ForumTopicRepository extends JpaRepository<ForumTopic, Long> {
	
	List<ForumTopic> findAllByDiscipline(Discipline discipline);

}

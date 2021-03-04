package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.User;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

	List<Topic> findAllByDiscipline(Discipline discipline);

	List<Topic> findAllByCreatedBy(User user);

}

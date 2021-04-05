package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.QuestionType;
import com.gutotech.fatecandoapi.model.Topic;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	List<Question> findAllByTopic(Topic topic);

	List<Question> findByTypeAndTopicIn(QuestionType type, List<Topic> topics);

}

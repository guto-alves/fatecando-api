package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.QuestionType;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.User;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	@Query("select q from Question q where q.type = ?1 and q.status = 'APPROVED' and q.topic in ?2")
	List<Question> findByTypeAndTopicIn(QuestionType type, List<Topic> topics);
	
	List<Question> findByUser(User user);

}

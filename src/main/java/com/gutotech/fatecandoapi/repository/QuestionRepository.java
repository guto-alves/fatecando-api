package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.User;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	@Query("select q from Question q where q.topic in ?1 and q.status = 'APPROVED'")
	List<Question> findByTopicIn(List<Topic> topics);
	
	@Query("select q from Question q where q.topic.subject in ?1")
	List<Question> findBySubject(List<Subject> subjects);
	
	List<Question> findByUser(User user);
	
	List<Question> findByTopic(Topic topic);

}

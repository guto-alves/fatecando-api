package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.QuestionType;
import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.UploadStatus;
import com.gutotech.fatecandoapi.model.User;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

	List<Topic> findAllBySubjectAndStatusOrderByItemOrder(Subject subject, UploadStatus status);

	@Query("select t from Topic t where t.status = ?1 order by t.subject.semester, t.itemOrder")
	List<Topic> findByStatus(UploadStatus status);

	List<Topic> findAllByCreatedBy(User user);

	@Query("select t from Topic t where t.itemOrder >= ?1 and t.itemOrder <= ?2 and t.subject.id = ?3 order by t.itemOrder")
	List<Topic> findAllBetween(long itemOrder1, long itemOrder2, long subjectId);

	@Query("select t from Topic t join t.topicUsers u where u.id.user.email = ?1 and u.favorite = true order by t.subject.name, t.itemOrder")
	List<Topic> findAllFavorites(String email);

	@Query("select t from Topic t join t.topicUsers u where u.id.user.email = ?1 and u.annotation != '' or u.annotation != '<p><br></p>' order by t.subject.name, t.itemOrder")
	List<Topic> findAllAnnotated(String email);

	@Query("select t from Topic t where t.subject.id = ?2 and (t.itemOrder = ?1 - 1L or t.itemOrder = ?1 + 1L) order by t.itemOrder")
	List<Topic> findPreviousAndNext(long itemOrder, long subjectId);

	@Query("select distinct t, s from Subject s, Topic t, Question q "
			+ "where s = t.subject and t = q.topic and t.status = 'APPROVED' and q.status = 'APPROVED' and q.type = ?2 and (s = ?1 or ?1 is null) "
			+ "order by s.semester, s.name, t.itemOrder")
	List<Topic> findFor(Subject subject, QuestionType type);

}

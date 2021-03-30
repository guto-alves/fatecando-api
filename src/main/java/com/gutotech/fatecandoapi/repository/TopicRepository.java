package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.UploadStatus;
import com.gutotech.fatecandoapi.model.User;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

	List<Topic> findAllByDisciplineAndStatusOrderByItemOrder(Discipline discipline, UploadStatus status);

	List<Topic> findAllByCreatedBy(User user);

	@Query("select t from Topic t where t.itemOrder >= ?1 and t.itemOrder <= ?2 and t.discipline.id = ?3 order by t.itemOrder")
	List<Topic> findAllBetween(long itemOrder1, long itemOrder2, long disciplineId);

	@Query("select t from Topic t join t.topicUsers u where u.id.user.email = ?1 and u.favorite = true order by t.discipline.name, t.itemOrder")
	List<Topic> findAllFavorites(String email);

	@Query("select t from Topic t join t.topicUsers u where u.id.user.email = ?1 and u.annotation != '' or u.annotation != '<p><br></p>' order by t.discipline.name, t.itemOrder")
	List<Topic> findAllAnnotated(String email);

	@Query("select t from Topic t where t.discipline.id = ?2 and (t.itemOrder = ?1 - 1L or t.itemOrder = ?1 + 1L) order by t.itemOrder")
	List<Topic> findPreviousAndNext(long itemOrder, long disciplineId);

}

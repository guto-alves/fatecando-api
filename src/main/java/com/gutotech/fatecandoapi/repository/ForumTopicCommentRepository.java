package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.ForumTopic;
import com.gutotech.fatecandoapi.model.ForumTopicComment;

@Repository
public interface ForumTopicCommentRepository extends JpaRepository<ForumTopicComment, Long> {
	
	List<ForumTopicComment> findAllByForumTopic(ForumTopic forumTopic);

}

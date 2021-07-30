package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.ForumThread;
import com.gutotech.fatecandoapi.model.Subject;

@Repository
public interface ForumThreadRepository extends JpaRepository<ForumThread, Long> {

	List<ForumThread> findBySubject(Subject subject);

}

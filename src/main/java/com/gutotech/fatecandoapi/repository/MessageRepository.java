package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Message;
import com.gutotech.fatecandoapi.model.User;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findAllByToOrderByDateDesc(User user);

	void deleteByTo(User user);
}

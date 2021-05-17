package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gutotech.fatecandoapi.model.Chat;
import com.gutotech.fatecandoapi.model.User;

public interface ChatRepository extends JpaRepository<Chat, Long> {

	@Query("select c from Chat c join c.users u where u = ?1 order by c.lastMessage.date desc")
	List<Chat> findByUser(User user);

}

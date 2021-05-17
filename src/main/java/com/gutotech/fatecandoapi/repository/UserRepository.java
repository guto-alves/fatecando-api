package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
	@Query("select u from User u where UPPER(u.fullName) like CONCAT('%', UPPER(:filter), '%') or UPPER(u.email) like CONCAT('%', UPPER(:filter), '%') order by u.fullName, u.email")
	List<User> findByFullNameOrEmailContaining(@Param("filter") String filter); 

}

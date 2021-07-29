package com.gutotech.fatecandoapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Test;
import com.gutotech.fatecandoapi.model.User;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

	Optional<Test> findByUser(User user);

}

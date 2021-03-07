package com.gutotech.fatecandoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.DisciplineUser;
import com.gutotech.fatecandoapi.model.DisciplineUserId;

@Repository
public interface DisciplineUserRepository extends JpaRepository<DisciplineUser, DisciplineUserId> {

}

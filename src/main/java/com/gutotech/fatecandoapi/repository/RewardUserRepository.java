package com.gutotech.fatecandoapi.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.RewardUser;

@Repository
public interface RewardUserRepository extends JpaRepository<RewardUser, Date> {

}

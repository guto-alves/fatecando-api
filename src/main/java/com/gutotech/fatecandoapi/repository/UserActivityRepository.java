package com.gutotech.fatecandoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.UserActivity;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {

}

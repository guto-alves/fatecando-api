package com.gutotech.fatecandoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.SubjectUser;
import com.gutotech.fatecandoapi.model.SubjectUserId;

@Repository
public interface SubjectUserRepository extends JpaRepository<SubjectUser, SubjectUserId> {

}

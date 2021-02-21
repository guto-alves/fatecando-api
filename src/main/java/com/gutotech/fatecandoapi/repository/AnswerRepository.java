package com.gutotech.fatecandoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Answer;
import com.gutotech.fatecandoapi.model.AnswerId;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, AnswerId> {

}

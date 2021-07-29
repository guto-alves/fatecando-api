package com.gutotech.fatecandoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.TestQuestion;
import com.gutotech.fatecandoapi.model.TestQuestionId;

@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestion, TestQuestionId> {

}

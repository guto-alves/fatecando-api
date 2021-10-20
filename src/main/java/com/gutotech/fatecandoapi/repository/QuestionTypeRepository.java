package com.gutotech.fatecandoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.QuestionType;

@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType, String> {

}

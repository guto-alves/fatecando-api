package com.gutotech.fatecandoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}

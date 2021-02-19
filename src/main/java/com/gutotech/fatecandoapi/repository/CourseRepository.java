package com.gutotech.fatecandoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gutotech.fatecandoapi.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findAllByOrderByName();
}

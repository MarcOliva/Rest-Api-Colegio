package com.oliva.marc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliva.marc.model.entity.Course;

public interface ICourseRepository extends JpaRepository<Course,Long> {

}

package com.oliva.marc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliva.marc.model.entity.Student;

public interface IStudentRepository extends JpaRepository<Student,Long> {
	
}

package com.oliva.marc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliva.marc.model.entity.Teacher;

public interface ITeacherRepository extends JpaRepository<Teacher,Long> {

}

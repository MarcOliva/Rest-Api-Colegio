package com.oliva.marc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliva.marc.model.entity.StudentSchedule;

public interface IStudentScheduleRepository extends JpaRepository<StudentSchedule,Long> {

}

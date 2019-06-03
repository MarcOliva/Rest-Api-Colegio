package com.oliva.marc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliva.marc.model.entity.TeacherSchedule;

public interface ITeacherScheduleRepository extends JpaRepository<TeacherSchedule,Long> {

}

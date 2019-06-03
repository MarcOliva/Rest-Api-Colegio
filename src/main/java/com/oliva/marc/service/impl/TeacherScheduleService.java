package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliva.marc.model.entity.TeacherSchedule;
import com.oliva.marc.model.repository.ITeacherScheduleRepository;
import com.oliva.marc.service.ITeacherScheduleService;

@Service
public class TeacherScheduleService implements ITeacherScheduleService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ITeacherScheduleRepository teacherScheduleRepository;

	@Transactional
	@Override
	public TeacherSchedule insert(TeacherSchedule entity) {
		return teacherScheduleRepository.save(entity);
	}
	@Transactional
	@Override
	public TeacherSchedule update(TeacherSchedule entity) {
		return teacherScheduleRepository.save(entity);
		
	}

	@Transactional
	@Override
	public void delete(Long id) {
		
		teacherScheduleRepository.deleteById(id);
	}

	@Transactional
	@Override
	public List<TeacherSchedule> findAll() {
		return teacherScheduleRepository.findAll();
	}

	@Transactional
	@Override
	public Optional<TeacherSchedule> findById(Long id) {
		return teacherScheduleRepository.findById(id);
	}
	
	
}

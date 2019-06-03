package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliva.marc.model.entity.StudentSchedule;
import com.oliva.marc.model.repository.IStudentScheduleRepository;
import com.oliva.marc.service.IStudentScheduleService;

@Service
public class StudentScheduleService implements IStudentScheduleService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IStudentScheduleRepository studentScheduleRepository;

	@Transactional
	@Override
	public StudentSchedule insert(StudentSchedule entity) {
		return studentScheduleRepository.save(entity);
	}
	@Transactional
	@Override
	public StudentSchedule update(StudentSchedule entity) {
		return studentScheduleRepository.save(entity);
	}
	@Transactional
	@Override
	public void delete(Long id) {
		studentScheduleRepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public List<StudentSchedule> findAll() {
		return studentScheduleRepository.findAll();
	}
	@Transactional
	@Override
	public Optional<StudentSchedule> findById(Long id) {
		return studentScheduleRepository.findById(id);
	}
	
	
}

package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliva.marc.model.entity.Teacher;
import com.oliva.marc.model.repository.ITeacherRepository;
import com.oliva.marc.service.ITeacherService;

@Service
public class TeacherService implements ITeacherService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ITeacherRepository teacherRepository;

	@Transactional
	@Override
	public Teacher insert(Teacher entity) {
		return teacherRepository.save(entity);
	}
	@Transactional
	@Override
	public Teacher update(Teacher entity) {
		return teacherRepository.save(entity);
	}
	@Transactional
	@Override
	public void delete(Teacher entity) {
		teacherRepository.delete(entity);
		
	}
	@Transactional
	@Override
	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}
	@Transactional
	@Override
	public Optional<Teacher> findById(Long id) {
		return teacherRepository.findById(id);
	}

}

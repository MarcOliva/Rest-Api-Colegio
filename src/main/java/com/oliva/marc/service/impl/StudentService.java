package com.oliva.marc.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliva.marc.model.entity.Student;
import com.oliva.marc.model.repository.IStudentRepository;
import com.oliva.marc.service.IStudentService;

@Service
public class StudentService implements IStudentService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IStudentRepository studentRepository;

	@Transactional
	@Override
	public Student insert(Student entity) {
		return studentRepository.save(entity);
	}

	@Transactional
	@Override
	public Student update(Student entity) {
		return studentRepository.save(entity);
	}

	@Transactional
	@Override
	public void delete(Student entity) {
		studentRepository.delete(entity);		
	}

	@Transactional
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Transactional
	@Override
	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}
	
	
}

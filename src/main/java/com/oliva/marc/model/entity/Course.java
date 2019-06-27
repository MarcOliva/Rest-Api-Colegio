package com.oliva.marc.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 20, nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "education_degree_id", nullable = false)
	private EducationDegree educationLevel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EducationDegree getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(EducationDegree educationLevel) {
		this.educationLevel = educationLevel;
	}
}

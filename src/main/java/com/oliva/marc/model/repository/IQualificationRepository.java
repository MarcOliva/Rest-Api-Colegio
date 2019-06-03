package com.oliva.marc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliva.marc.model.entity.Qualification;

public interface IQualificationRepository extends JpaRepository<Qualification,Long> {

}

package com.oliva.marc.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliva.marc.model.entity.Assistance;

public interface IAssistanceRepository extends JpaRepository<Assistance,Long> {

}

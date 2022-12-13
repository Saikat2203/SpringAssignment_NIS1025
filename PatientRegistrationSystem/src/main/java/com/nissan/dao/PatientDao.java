package com.nissan.dao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Patient;

@Repository
public interface PatientDao extends JpaRepositoryImplementation<Patient, Integer> {

}

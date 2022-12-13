package com.nissan.dao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.entity.Professor;

@Repository
public interface ProfessorDao extends JpaRepositoryImplementation<Professor, Integer> {

}

package com.nissan.service;

import java.util.List;

import com.nissan.entity.Professor;

public interface IProfessorService {

	Professor addNewProfessor(Professor professor);
	
	Professor removeProfessor(int professorId);
	
	Professor getProfessorById(int professorId);
	
	List<Professor> getAllProfessor();
	
	Professor updateSalaryById(int professorId, double salary);
	
}

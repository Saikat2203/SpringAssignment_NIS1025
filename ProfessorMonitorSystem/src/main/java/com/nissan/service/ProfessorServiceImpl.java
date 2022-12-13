package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nissan.dao.ProfessorDao;
import com.nissan.entity.Professor;

public class ProfessorServiceImpl implements IProfessorService {

	@Autowired
	private ProfessorDao professorDao;
	
	@Override
	public Professor addNewProfessor(Professor professor) {
		return professorDao.save(professor);
	}

	@Override
	public Professor removeProfessor(int professorId) {
		Professor deleteProfessor = professorDao.findById(professorId).orElse(null);
		
		if(deleteProfessor == null) {
			return null;
		} else {
			professorDao.delete(deleteProfessor);
			return deleteProfessor;
		}
	}

	@Override
	public Professor getProfessorById(int professorId) {
		return 
	}

	@Override
	public List<Professor> getAllProfessor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateSalaryById(int professorId, double salary) {
		// TODO Auto-generated method stub

	}

}

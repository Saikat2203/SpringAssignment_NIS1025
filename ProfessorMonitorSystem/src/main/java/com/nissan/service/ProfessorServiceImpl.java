package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.dao.ProfessorDao;
import com.nissan.entity.Professor;

@Service
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
		return professorDao.findById(professorId).orElse(null);
	}

	@Override
	public List<Professor> getAllProfessor() {
		return professorDao.findAll();
	}

	@Override
	public Professor updateSalaryById(int professorId, double salary) {
		Professor salaryUpdateProfessor = professorDao.findById(professorId).orElse(null);
		
		if(salaryUpdateProfessor == null) {
			return null;
		} else {
			salaryUpdateProfessor.setSalary(salary);
			return professorDao.save(salaryUpdateProfessor);
		}
	}

}

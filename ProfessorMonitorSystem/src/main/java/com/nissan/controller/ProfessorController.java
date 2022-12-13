package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.entity.Professor;
import com.nissan.service.IProfessorService;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {

	@Autowired
	private IProfessorService professorService;

	@GetMapping
	public ResponseEntity<?> getAllProfessors() {
		List<Professor> professorList = professorService.getAllProfessor();

		if (professorList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Database is empty!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(professorList);
		}
	}

	@PostMapping
	public ResponseEntity<?> addNewProfessor(@RequestBody Professor professor) {
		Professor newProfessor = professorService.addNewProfessor(professor);
		return ResponseEntity.status(HttpStatus.OK)
				.body("Professor " + newProfessor.getFirstName() + " added to the database successfully!!!");
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteProfessor(@PathVariable int id) {
		Professor deleteProfessor = professorService.removeProfessor(id);

		if (deleteProfessor == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Professor with " + id + " not found in the database!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Professor " + deleteProfessor.getFirstName() + " with "
					+ id + " has been successfully removed from the database!!!");
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getProfessorById(@PathVariable int id) {
		Professor findProfessor = professorService.getProfessorById(id);

		if (findProfessor == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor with id" + id + " is not available in the database!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(findProfessor);
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateProfessorSalary(@PathVariable int id, @RequestParam double salary) {
		Professor salaryProfessor = professorService.updateSalaryById(id, salary);
		
		if(salaryProfessor == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Professor with id " + id + " is not found in the database!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Professor " + salaryProfessor.getFirstName() + "'s salary has been successfully update to " + salary);
		}
	}
}

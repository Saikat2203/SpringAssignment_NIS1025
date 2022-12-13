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
import org.springframework.web.bind.annotation.RestController;

import com.nissan.dao.PatientDao;
import com.nissan.entity.Patient;
import com.nissan.service.IPatientService;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	private IPatientService patientService;

	@GetMapping
	public ResponseEntity<?> getAllPatients() {
		List<Patient> patientList = patientService.getAllPatients();

		if (patientList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The database is empty");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(patientList);
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getPatientById(@PathVariable int id) {
		Patient patient = patientService.getPatientById(id);

		if (patient == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(patient);
		}
	}

	@PostMapping
	public ResponseEntity<?> savePatient(@RequestBody Patient patient) {
		Patient newPatient = patientService.addPatient(patient);
		
		if(newPatient == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not added!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(newPatient.getPatientName() + " added to the database successfully!!!");
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updatePatientDetails(@PathVariable Integer patientId, @RequestBody Patient patient) {
		Patient updatePatient = patientService.updatePatient(patientId, patient);
		
		if(updatePatient == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Patient detailts updated successfully!!!");
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletePatient(@PathVariable int id) {
		Patient deletePatient = patientService.deletePatient(id);
		
		if(deletePatient == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Patient " + deletePatient.getPatientName() + " deleted successfully!!!");
		}
	}

}

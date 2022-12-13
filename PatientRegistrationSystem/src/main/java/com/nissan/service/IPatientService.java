package com.nissan.service;

import java.util.List;

import com.nissan.entity.Patient;

public interface IPatientService {
	
	List<Patient> getAllPatients();
	
	Patient getPatientById(int id);
	
	Patient addPatient(Patient patient);
	
	Patient updatePatient(int patientId, Patient patient);
	
	Patient deletePatient(int patientId);
}

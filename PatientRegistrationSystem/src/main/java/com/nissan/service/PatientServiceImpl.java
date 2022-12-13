package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.dao.PatientDao;
import com.nissan.entity.Patient;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientDao patientDao;

	@Override
	public List<Patient> getAllPatients() {
		return patientDao.findAll();
	}

	@Override
	public Patient getPatientById(int id) {
		return patientDao.findById(id).orElse(null);
	}

	@Override
	public Patient addPatient(Patient patient) {
		Patient aPatient = new Patient(patient.getRegistrationNo(), patient.getPatientName(),
				patient.getDateOfBirth(), patient.getGender(), patient.getAddress(), patient.getPhoneNo());
		return patientDao.save(aPatient);
	}

	@Override
	public Patient updatePatient(int patientId, Patient patient) {
		Patient searchPatient = patientDao.findById(patientId).orElse(null);

		if (searchPatient == null) {
			return null;
		} else {
			searchPatient.setPatientName(patient.getPatientName());
			searchPatient.setAddress(patient.getAddress());
			searchPatient.setPhoneNo(patient.getPhoneNo());
			return patientDao.save(searchPatient);
		}
	}

	@Override
	public Patient deletePatient(int patientId) {
		Patient deletePatient = patientDao.findById(patientId).orElse(null);

		if (deletePatient == null) {
			return null;
		} else {
			patientDao.delete(deletePatient);
			return deletePatient;
		}
	}

}

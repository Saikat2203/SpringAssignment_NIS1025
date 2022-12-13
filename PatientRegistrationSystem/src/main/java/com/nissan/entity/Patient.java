package com.nissan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tblPatient")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;
	
	@JsonProperty("registration_no")
	private String registrationNo;
	
	@JsonProperty("patient_name")
	private String patientName;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonProperty("date_of_birth")
	private DateTime dateOfBirth;
	
	private String gender;
	
	private String address;
	
	@JsonProperty("phone_no")
	private Long phoneNo;

	public Patient(String registrationNo, String patientName, DateTime dateOfBirth, String gender, String address,
			Long phoneNo) {
		this.registrationNo = registrationNo;
		this.patientName = patientName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public Patient(String patientName, String address, Long phoneNo) {
		this.patientName = patientName;
		this.address = address;
		this.phoneNo = phoneNo;
	}
	
}

package com.nissan.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tblProfessor")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	private Integer professorId; 
	
	private Integer managerId; 
	
	private String firstName;
	
	private String lastName;
	
	private Integer deptNo;
	
	private Double salary;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime joiningDate;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime dateOfBirth;
	
	private String gender;

	public Professor(Integer managerId, String firstName, String lastName, Integer deptNo, Double salary,
			DateTime joiningDate, DateTime dateOfBirth, String gender) {
		this.managerId = managerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptNo = deptNo;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
}

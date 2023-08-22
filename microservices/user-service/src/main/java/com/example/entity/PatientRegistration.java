package com.example.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="patient_registration")
public class PatientRegistration {
	
	public PatientRegistration(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Date dateOfBirth = new Date(0);
	
	private int age = 0;

	private String gender = "male";
	
	private String address = "NA";
	
	private String city = "NA";
	
	private String state = "NA";
	
	private int pincode = 0;
	
	private Long phone = 0L;
	
	private String password;

}
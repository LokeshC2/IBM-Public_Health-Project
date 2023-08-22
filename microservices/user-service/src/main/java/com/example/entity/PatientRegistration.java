package com.example.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name="patient_registration")
public class PatientRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Date dateOfBirth;
	
	private int age;

	private String gender;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private int pincode;
	
	private Long phone;
	
	private String password;

}
package com.example.ui;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientRegistrationDto {
	
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
}

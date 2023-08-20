package com.example.entity;


import java.util.Date;
import java.util.UUID;

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
@Table(name = "payment_book")
public class Payment {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	private Long appointmentId;
	private String name;
	private String email;
	private Long phone;
	private Long account;
	private boolean paymentStatus;
	private Date paymentDate;
	private UUID txnId;
	
	
	
}

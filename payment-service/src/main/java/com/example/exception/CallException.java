package com.example.exception;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
@Getter
public class CallException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
}

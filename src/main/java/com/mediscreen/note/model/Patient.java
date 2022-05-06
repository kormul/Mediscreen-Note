package com.mediscreen.note.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	private boolean man;
	
	private Address address;
	
	private String phone;
}

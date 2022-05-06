package com.mediscreen.note.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;

	private boolean man;
	
	private String phone;
    
	private String address;
	
	private String city;
	
	private String zip;
	
	private String country;
	
}

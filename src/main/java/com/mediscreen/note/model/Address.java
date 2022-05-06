package com.mediscreen.note.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	private String address;
	
	private String city;
	
	private String zip;
	
	private String country;
	
}

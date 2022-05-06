package com.mediscreen.note.service;

import com.mediscreen.note.dto.PatientDTO;
import com.mediscreen.note.model.Patient;

public interface ConvertDtoModel {
	
	public Patient patientDtoToPatient(PatientDTO patientDTO);
	
}

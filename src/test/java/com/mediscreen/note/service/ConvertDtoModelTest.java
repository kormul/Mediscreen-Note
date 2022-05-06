package com.mediscreen.note.service;

import static org.junit.Assert.assertTrue;

import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mediscreen.note.dto.PatientDTO;
import com.mediscreen.note.model.Patient;


@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConvertDtoModelTest {
	
	@Autowired
	ConvertDtoModel convertDtoModel;
	
	@Test
	public void patientDtoToPatientTest() {
		
       PatientDTO patientDTO = new PatientDTO(1,"Guillaume","Aubert", Date.from(Instant.now()), true, "0669120050", "4 la ruelle","Noisy-Rudignon", "77940", "France");
       Patient patient = convertDtoModel.patientDtoToPatient(patientDTO);
       
       assertTrue(patient.getId() == 1);
       assertTrue(patient.getFirstName().equalsIgnoreCase("guillaume"));
       assertTrue(patient.getLastName().equalsIgnoreCase("Aubert"));
       assertTrue(patient.isMan());
       assertTrue(patient.getPhone().equalsIgnoreCase("0669120050"));
       assertTrue(patient.getAddress().getAddress().equalsIgnoreCase("4 la ruelle"));
       assertTrue(patient.getAddress().getCity().equalsIgnoreCase("Noisy-Rudignon"));
       assertTrue(patient.getAddress().getZip().equalsIgnoreCase("77940"));
       assertTrue(patient.getAddress().getCountry().equalsIgnoreCase("France"));
       
	}

}

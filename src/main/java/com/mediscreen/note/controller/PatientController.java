package com.mediscreen.note.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mediscreen.note.service.webclient.PatientWebClient;

@Controller
public class PatientController {
	
	private Logger logger = LogManager.getLogger();

	@Autowired
	PatientWebClient patientWebClient;

	@GetMapping("/patient/list")
	public String getListPatient(Model model) {
		logger.info("Get : List Patient");
		
		model.addAttribute("patients", patientWebClient.getListPatient());
		return "List";
	}
}

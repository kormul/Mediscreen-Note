package com.mediscreen.note.service.webclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.mediscreen.note.dto.PatientDTO;

@Service
public class PatientWebClient {

	public String dockerURLLocation = "http://localhost:8080";
	
	private Logger logger = LogManager.getLogger();

	
	public List<PatientDTO> getListPatient(){
		logger.debug("PatientWebClient : getListPatient");

		List<PatientDTO> patientDTOList;
		
		RestTemplate restTemplate = new RestTemplate();
 

        ResponseEntity<List<PatientDTO>> result = restTemplate.exchange(dockerURLLocation+"/rest/patient/list/",
                       HttpMethod.GET, null, new ParameterizedTypeReference<List<PatientDTO>>(){});

        patientDTOList= result.getBody();
		
		return patientDTOList;
	}
	
	public PatientDTO getPatient(int id){
		logger.debug("PatientWebClient : getPatient");

		PatientDTO patientDTO;
		
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
 

        ResponseEntity<PatientDTO> result = restTemplate.getForEntity(dockerURLLocation+"/rest/patient?id=" + id, PatientDTO.class);
        
        patientDTO= result.getBody();
		
		return patientDTO;
	}
}

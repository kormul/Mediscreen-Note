package com.mediscreen.note.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreen.note.model.Note;
import com.mediscreen.note.service.NoteService;

@RestController
public class NoteRestController {
	
	private Logger logger = LogManager.getLogger();

	@Autowired
	NoteService noteService;
	
	@GetMapping("/rest/note/list")
	public List<Note> getListNote(@RequestParam(value = "id", required = true) int id) {
		logger.info("get : RestListNote");
		
		return noteService.getAllByPatientId(id);
	}

}

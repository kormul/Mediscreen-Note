package com.mediscreen.note.controller;

import java.math.BigInteger;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.mediscreen.note.model.Note;
import com.mediscreen.note.service.NoteService;

@Controller
public class NoteController {
	
	private Logger logger = LogManager.getLogger();
	
	@Autowired
	NoteService noteService;
	
	@GetMapping("/note/list")
	public String getNoteList(@RequestParam(value = "id", required = true) int id, Model model) {
		logger.info("Get : List Note Patient");
		
		model.addAttribute("NotePatient", noteService.getAllByPatientId(id));

		return "ListNote";
	}

	@GetMapping("/note/add")
	public String getAddNote(@RequestParam(value = "id", required=true) int id, Model model) {
		logger.info("get : AddNote");
		
		Note note = new Note();
		note.setPatientId(id);

		model.addAttribute("Note", note);
		
		return "Add";
		
	}
	
	@PostMapping("/note/add")
	public RedirectView postNotePatient(@Valid @ModelAttribute("Note") Note note, BindingResult result){
		logger.info("Post : AddNote");
		
		if(!result.hasErrors()) {
			noteService.createNote(note);
			return new RedirectView("/note/list?id="+note.getPatientId());
		}
		else {
			for(ObjectError objectError : result.getAllErrors()) {
				logger.info(objectError.toString());
			}
			return new RedirectView("/note/add?id="+note.getPatientId());
		}

	}
	
	@GetMapping("/note/delete")
	public RedirectView getDeleteNote(@RequestParam(value = "id", required = true) BigInteger id) {
		logger.info("Get : Delete Note");
		
		Note note = noteService.getbyId(id);
		noteService.deleteById(id);
		
		return new RedirectView("/note/list?id="+note.getPatientId());
	}
}

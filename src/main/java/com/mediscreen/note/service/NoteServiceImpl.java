package com.mediscreen.note.service;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen.note.model.Note;
import com.mediscreen.note.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService{

	private Logger logger = LogManager.getLogger();

	
	@Autowired
	NoteRepository noteRepository;
	
	@Override
	public List<Note> getAllByPatientId(int id) {
		logger.debug("NoteService : getAllByPatientId");

		List<Note> noteList = noteRepository.findByPatientId(id);
		
		return noteList;
	}

	@Override
	public Note getbyId(BigInteger id) {
		logger.debug("NoteService : getbyId");

		Note note= noteRepository.getById(id);
		return note;
	}

	@Override
	public boolean deleteById(BigInteger id) {
		logger.debug("NoteService : deleteById");

		noteRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean createNote(Note note) {
		logger.debug("NoteService : createNote");

		note.setDate(LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Paris")));
		noteRepository.save(note);
		return false;
	}

}

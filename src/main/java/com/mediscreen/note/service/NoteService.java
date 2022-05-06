package com.mediscreen.note.service;

import java.math.BigInteger;
import java.util.List;

import com.mediscreen.note.model.Note;

public interface NoteService {

	
	public List<Note> getAllByPatientId(int id);
	
	public Note getbyId(BigInteger id);
	
	public boolean deleteById(BigInteger id);
	
	public boolean createNote(Note note);
}

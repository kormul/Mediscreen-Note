package com.mediscreen.note.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mediscreen.note.model.Note;

public interface NoteRepository extends MongoRepository<Note, Integer>{
	
	public List<Note> findByPatientId(int id);
	
	public Note getById(BigInteger id);
	
	public void deleteById(BigInteger id);

}

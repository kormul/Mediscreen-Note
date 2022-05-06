package com.mediscreen.note.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mediscreen.note.model.Note;
import com.mediscreen.note.service.NoteService;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteControllerTest {

    private MockMvc mockMvc;
	
    @Autowired
    private WebApplicationContext webContext;

    @Autowired
    private NoteService noteService;
    
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();

    }
    
    @Test
    public void getListNote() throws Exception{
    	
    	mockMvc.perform(get("/note/list?id=1"))
    	.andExpect(status().isOk())
    	.andExpect(model().attributeExists("NotePatient"))
        .andReturn();
    	
    	
    }
    
    @Test
    public void getAddNote() throws Exception{
    	
    	mockMvc.perform(get("/note/add?id=1"))
    	.andExpect(status().isOk())
    	.andExpect(model().attributeExists("Note"))
        .andReturn();
    }
    
    @Test
    public void postAddNote() throws Exception{
    	
    	Note note = new Note(BigInteger.valueOf(1),1, LocalDateTime.now(),"memoTest");
    	mockMvc.perform(post("/note/add")
        .flashAttr("Note", note)
        .param("id", "1")
        .param("patientId", "1")
        .param("note", "memoTest")
        )
    	.andExpect(status().is3xxRedirection())
        .andReturn();
    	
    }	
    
    @Test
    public void getDeleteNote() throws Exception{
    	
    	String id = noteService.getAllByPatientId(1).get(0).getId().toString();
    	
    	mockMvc.perform(get("/note/delete?id="+id))
    	.andExpect(status().is3xxRedirection())
        .andReturn();
    	
    }
}

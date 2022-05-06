package com.mediscreen.note.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="note")
public class Note {
	
	@Id
	private BigInteger id;
	
	@Field("patientId")
	private int patientId;
	
    @Field("date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;
    
    @Field("memo")
    private String memo;

}

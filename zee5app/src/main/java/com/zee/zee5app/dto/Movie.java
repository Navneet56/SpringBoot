package com.zee.zee5app.dto;

import java.sql.Blob;
import java.time.LocalDate;

import javax.naming.InvalidNameException;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.zee.zee5app.enums.Genres;
import com.zee.zee5app.enums.Languages;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.InvalidLengthException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
//@Table(name="movies_table")
public class Movie {
	@Id
	@GenericGenerator(name="movieIdGenerator",strategy="com.zee.zee5app.utils.MovieIdGenerator")
	@GeneratedValue(generator = "movieIdGenerator")
	private String movieId;
    private String actors;
    private String movieName;
    private String director;
    
    private Genres genre;
    private String production;
    
    private String languages;
    private float movieLength;
    
    private String  trailer1;
  
    
    
}

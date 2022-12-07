package com.emily.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "DVD_library")
public class DVD {

	@Id
	@Column(name="dvd_title")
    private String title;
	
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	@Column(name="rating")
    private String rating;
	
	@Column(name="director_name")
    private String directorName;
	
	@Column(name="studio")
    private String studio;
	
	@Column(name="user_rating")
    private String userRating;
}

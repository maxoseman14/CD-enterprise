package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CD {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	private String title;
	private ArrayList<String> artist = new ArrayList<String>();
	
	public CD () {}
	
	public CD(String title, ArrayList<String> artist) {
		this.title = title;
		this.artist = artist;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<String> getName() {
		return artist;
	}

	public void setName(ArrayList<String> artist) {
		this.artist = artist;
	}

}

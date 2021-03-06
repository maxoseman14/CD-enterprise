package com.qa.persistence.domain;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;


@Entity
public class CD {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	@Size(min=2, max=10)
	private String title;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.EAGER
			)
	@Size(min=1)
	private Collection<Artist> artist;
	
	public CD () {}
	
	public CD(String title, Collection<Artist> artist) {
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

	public Collection<Artist> getName() {
		return artist;
	}

	public void setName(Collection<Artist> artist) {
		this.artist = artist;
	}

}

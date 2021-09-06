package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Actor {
	private int id;
	private String first_name;
	private String last_name;
	private List<Film> films;

	public Actor(int id, String first_name, String last_name) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		
	}

	public Actor(int id, String first_name, String last_name, List<Film> films) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.films = films;
	}

	public Actor() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public List<Film> getFilms() {
		System.out.println("-----Actor Films-----");
		for(Film film : films) {
			System.out.println("Title: " + film.getTitle() + " Year: " 
					+ film.getReleaseYear() + " Rating: " + film.getRating() 
					+ " Description: " + film.getDescription() 
					+ " Language: " + film.getLanguage());
		}
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public int hashCode() {
		return Objects.hash(films, first_name, id, last_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return Objects.equals(films, other.films) && Objects.equals(first_name, other.first_name) && id == other.id
				&& Objects.equals(last_name, other.last_name);
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + "]";
	}

}

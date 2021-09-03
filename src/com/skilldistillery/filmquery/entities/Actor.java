package com.skilldistillery.filmquery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Actor {
	private String first_name;
	private String last_name;
	private int id;
	private List<Film> films = new ArrayList<>();
	
	public Actor(String first_name, String last_name, int id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.id = id;
	}

	public Actor() {
		super();
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(first_name, id, last_name);
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
		return Objects.equals(first_name, other.first_name) && id == other.id
				&& Objects.equals(last_name, other.last_name);
	}

	@Override
	public String toString() {
		return "Actor [first_name=" + first_name + ", last_name=" + last_name + ", id=" + id + "]";
	}

	public void setFilms(Film findFilmById) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}

package com.skilldistillery.filmquery.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

	private void test() {

	}

	private void launch() {
		Scanner input = new Scanner(System.in);
		int choice = 0;

		do {
			System.out.println("\n\n\n\n");
			System.out.println("------------Welcome to mySQL database------------");
			System.out.println();
			System.out.println("		1. Look up film by numeric id");
			System.out.println("		2. Look up film by keyword search");
			System.out.println("		3. Quit application \n\n\n\n");
			System.out.println("Please make a numeric selection: \n");
			choice = input.nextInt();
			input.nextLine();

			switch (choice) {
			case 1:
				System.out.println("You have selected option 1 to search for film by numeric id");
				System.out.println("\n\n\n");
				System.out.println("Please enter the numeric id of the film: ");
				int menuChoice = input.nextInt();
				Film film = db.findFilmById(menuChoice);
				if (film == null) {
					System.out.println("No results found!  \n\n\n\n");
					break;
				} else {
					showFilm(film);
				}
				break;

			case 2:
				System.out.println("You have selected option 2 to search for film by keyword");
				System.out.println("\n\n\n");
				System.out.println("Please enter the desired keyword: ");
				String keywordChoice = input.nextLine();
				List<Film> filmList = db.findFilmByKeyword(keywordChoice);
				if (filmList.isEmpty()) {
					System.out.println("No results found!  \n\n\n\n");
					break;
				} else {
					showFilms(filmList);
				}
				break;
			case 3:

				System.out.println("You have selected option 3 to exit.  Goodbye!");
				System.exit(0);
				break;

			}
		} while (choice != 3);

		input.close();
	}

	public void showFilm(Film film) {
		System.out.println("Title: " + film.getTitle() + " Year: " + film.getReleaseYear() + " Rating: "
				+ film.getRating() + " Description: " + film.getDescription() + " Language: " + film.getLanguage());

		film.getActors();
	}
	
	public void showFilms(List<Film> films) {

		for (Film film : films) {

			System.out.println("Title: " + film.getTitle() + " Year: " + film.getReleaseYear() + " Rating: "
					+ film.getRating() + " Description: " + film.getDescription() + " Language: " + film.getLanguage());
			showActors(film);

		}
	}

	public void showActors(Film film) {
		film.setActors(db.findActorsByFilmId(film.getId()));
		film.getActors();

	}

}

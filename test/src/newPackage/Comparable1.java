package newPackage;

//Java program to demonstrate 
//the use of Comparable for sorting
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pack2.Movie;

//Movie class implements Comparable 
//interface to define default sorting
class Movie implements Comparable<Movie> {
	private String name;
	private double rating;
	private int year;

	// Constructor
	public Movie(String name, double rating, int year) {
		this.name = name;
		this.rating = rating;
		this.year = year;
	}

	// Implementation of the compareTo method
	// for default sorting by year
	public int compareTo(Movie m) {

		// Sort movies in ascending
		// order of year
		return this.year - m.year;
	}

	// Getter methods
	public String getName() {
		return name;
	}

	public double getRating() {
		return rating;
	}

	public int getYear() {
		return year;
	}
}

public class Comparable1 {
	public static void main(String[] args) {

		// Create a list of movies
		List<Movie> l = new ArrayList<>();
		l.add(new Movie("Star Wars", 8.7, 1977));
		l.add(new Movie("Empire Strikes Back", 8.8, 1980));
		l.add(new Movie("Return of the Jedi", 8.4, 1983));

		// Sort movies using Comparable's
		// compareTo method by year
		Collections.sort(l);

		// Display the sorted list of movies
		System.out.println("Movies after sorting by year:");
		for (Movie m : l)
		{
			System.out.println(m.getName() + " " + m.getRating() + " " + m.getYear());
		}
	}
}

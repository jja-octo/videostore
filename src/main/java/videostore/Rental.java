package videostore;

import videostore.movie.Movie;

public class Rental
{
	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
		this.amount = this.getMovie().rentalAmount(getDaysRented());
	}

	public int getDaysRented () {
		return daysRented;
	}

	public Movie getMovie () {
		return movie;
	}

	public double amount() {
		return amount;
	}
	
	public int frequentRenterPoints() {
		return movie.frequentRenterPoints(daysRented);
	}

	private final double amount;
	private final Movie movie;
	private final int daysRented;
}
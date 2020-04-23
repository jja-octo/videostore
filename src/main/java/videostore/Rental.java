package videostore;

import static videostore.Pricing.NEW_RELEASE;

public class Rental
{
	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
		this.amount = getMovie().getPricing().rentalAmount(getDaysRented());
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
		int renterPoints;
		if (this.getMovie ().getPricing() == NEW_RELEASE
							&& this.getDaysRented() > 1) {
			renterPoints = 2;
		} else {
			renterPoints = 1;
		}
		return renterPoints;
	}

	private final double amount;
	private final Movie movie;
	private final int daysRented;
}
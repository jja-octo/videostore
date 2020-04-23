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
		int delta;
		if (this.getMovie ().getPricing() == NEW_RELEASE
							&& this.getDaysRented() > 1) {
			delta = 2;
		} else {
			delta = 1;
		}
		return delta;
	}

	private final double amount;
	private final Movie movie;
	private final int daysRented;
}
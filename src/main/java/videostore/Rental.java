package videostore;

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

	private final double amount;
	private final Movie movie;
	private final int daysRented;
}
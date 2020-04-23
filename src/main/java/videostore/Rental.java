package videostore;

public class Rental
{
	public Rental (Movie movie, int daysRented) {
		this.movie 		= movie;
		this.daysRented = daysRented;
	}
	
	public int getDaysRented () {
		return daysRented;
	}
	
	public Movie getMovie () {
		return movie;
	}
	
	public double amount() {
		return getMovie().getPricing().computeAmount(getDaysRented());
	}
	
	private Movie movie;
	private int daysRented;
}
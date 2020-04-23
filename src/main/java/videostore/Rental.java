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
		int daysRented = getDaysRented();
		double amountToAdd = 0;
		switch (getMovie ().getPricing()) {
			case REGULAR:
				amountToAdd = getMovie().getPricing().computeAmount(daysRented);
				break;
			case NEW_RELEASE:
				amountToAdd = getMovie().getPricing().computeAmount(daysRented);
				break;
			case CHILDREN:
				amountToAdd = getMovie().getPricing().computeAmount(daysRented);
				break;
		}
		return amountToAdd;
	}

	
	private Movie movie;
	private int daysRented;
}
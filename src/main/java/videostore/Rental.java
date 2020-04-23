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
		double amountToAdd = 0;
		int daysRented = getDaysRented();
		switch (getMovie ().getPricing()) {
			case REGULAR:
				amountToAdd = computeAmountRegular(daysRented);
				break;
			case NEW_RELEASE:
				amountToAdd = computeAmountNewRelease(daysRented);
				break;
			case CHILDREN:
				amountToAdd = computeAmountChildren(daysRented);
				break;
		}
		return amountToAdd;
	}

	private double computeAmountChildren(int daysRented) {
		double amountToAdd;
		double childrenBasePrice = 1.5;
		int childrenDaysPenalty = 3;
		double childrenDailyPrice = 1.5;
		amountToAdd = computeAmount(daysRented, childrenBasePrice, childrenDaysPenalty,
				childrenDailyPrice);
		return amountToAdd;
	}

	private double computeAmountNewRelease(int daysRented) {
		double amountToAdd;
		double newReleaseBasePrice = 0;
		int newReleaseDaysPenalty = 0;
		int newReleaseDailyPrice = 3;
		amountToAdd = computeAmount(daysRented, newReleaseBasePrice, newReleaseDaysPenalty,
				newReleaseDailyPrice);
		return amountToAdd;
	}

	private double computeAmountRegular(int daysRented) {
		double amountToAdd;
		int regularBasePrice = 2;
		int regularDaysPenalty = 2;
		double regularDailyPrice = 1.5;
		amountToAdd = computeAmount(daysRented, regularBasePrice, regularDaysPenalty,
				regularDailyPrice);
		return amountToAdd;
	}

	private static double computeAmount(int daysRented, double regularBasePrice, int regularDaysPenalty, double regularDailyPrice) {
			double regularAmountToAdd = regularBasePrice;
			if (daysRented > regularDaysPenalty) {
				regularAmountToAdd += (daysRented - regularDaysPenalty) * regularDailyPrice;
			}
			return regularAmountToAdd;
		}
	
	private Movie movie;
	private int daysRented;
}
package videostore;

import java.util.Collection;
import java.util.LinkedList;

import static videostore.Movie.Pricing.NEW_RELEASE;

public class Customer 
{
	public Customer (String name) {
		this.name = name;
	}
	
	public void addRental (Rental rental) {
		rentals.add(rental);
	}
	
	public String getName () {
		return name;
	}
	
	public String statement () {
		double 				totalAmount 			= 0;
		int					frequentRenterPoints 	= 0;
		String 				result 					= "Rental Record for " + getName () + "\n";
		
		for(var each : rentals) {
			double 		thisAmount = 0;
			
			thisAmount += rentalAmount(each);
			
			frequentRenterPoints++;
			
			if (each.getMovie ().getPricing() == NEW_RELEASE 
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;
				
			result += "\t" + each.getMovie ().getTitle () + "\t"
								+ String.valueOf (thisAmount) + "\n";
			totalAmount += thisAmount;
				
		}
		
		result += "You owed " + String.valueOf (totalAmount) + "\n";
		result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";
		
		
		return result;
	}

	private double rentalAmount(Rental each) {
		double amountToAdd = 0;
		int daysRented = each.getDaysRented();
		switch (each.getMovie ().getPricing()) {
			case REGULAR:
				int regularBasePrice = 2;
				int regularDaysPenalty = 2;
				double regularDailyPrice = 1.5;
				amountToAdd = computeAmount(daysRented, regularBasePrice, regularDaysPenalty,
						regularDailyPrice);
				break;
			case NEW_RELEASE:
				double newReleaseBasePrice = 0;
				int newReleaseDaysPenalty = 0;
				int newReleaseDailyPrice = 3;
				amountToAdd = computeAmount(daysRented, newReleaseBasePrice, newReleaseDaysPenalty,
						newReleaseDailyPrice);
				break;
			case CHILDREN:
				double childrenBasePrice = 1.5;
				int childrenDaysPenalty = 3;
				double childrenDailyPrice = 1.5;
				amountToAdd = computeAmount(daysRented, childrenBasePrice, childrenDaysPenalty,
						childrenDailyPrice);
				break;
		}
		return amountToAdd;
	}

	private double computeAmount(int daysRented, double regularBasePrice, int regularDaysPenalty, double regularDailyPrice) {
		double regularAmountToAdd = 0;
		regularAmountToAdd += regularBasePrice;
		if (daysRented > regularDaysPenalty) {
			regularAmountToAdd += (daysRented - regularDaysPenalty) * regularDailyPrice;
		}
		return regularAmountToAdd;
	}


	private String name;
	private Collection<Rental> rentals = new LinkedList<>();
}
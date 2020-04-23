package videostore;

import java.util.Collection;
import java.util.LinkedList;

import static videostore.Pricing.NEW_RELEASE;

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
		
		for(var rental : rentals) {
			double 		thisAmount = 0;

			thisAmount += rental.amount();
			
			frequentRenterPoints++;
			
			if (rental.getMovie ().getPricing() == NEW_RELEASE 
					&& rental.getDaysRented() > 1)
				frequentRenterPoints++;
				
			result += "\t" + rental.getMovie ().getTitle () + "\t"
								+ String.valueOf (thisAmount) + "\n";
			totalAmount += thisAmount;
				
		}
		
		result += "You owed " + String.valueOf (totalAmount) + "\n";
		result += "You earned " + String.valueOf (frequentRenterPoints) + " frequent renter points\n";
		
		
		return result;
	}

	private String name;
	private Collection<Rental> rentals = new LinkedList<>();
}
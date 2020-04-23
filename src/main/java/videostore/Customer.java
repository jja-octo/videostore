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
		int frequentRenterPoints = 0;
		var result = new StringBuilder("Rental Record for " + getName() + "\n");
		
		for(var rental : rentals) {
			double thisAmount = rental.amount();

			result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");

			frequentRenterPoints+=1;
			if (rental.getMovie ().getPricing() == NEW_RELEASE
					&& rental.getDaysRented() > 1) {frequentRenterPoints+=1;}

		}
		
		double totalAmount = rentals.stream()
				.map(Rental::amount)
				.reduce(0.0, Double::sum);
		
		result.append("You owed ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points\n");
		
		
		return result.toString();
	}

	private String name;
	private Collection<Rental> rentals = new LinkedList<>();
}
package videostore;

import java.util.Collection;
import java.util.LinkedList;

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
		var frequentRenterPoints = rentals.stream()
				.mapToInt(Rental::frequentRenterPoints)
				.sum();

		double totalAmount = rentals.stream()
				.map(Rental::amount)
				.reduce(0.0, Double::sum);

		var statement = new StringBuilder("Rental Record for " + getName() + "\n");
		statement.append( rentals.stream()
				.map(rental -> "\t" + rental.getMovie ().getTitle () + "\t"
						+ rental.amount() + "\n")
				.reduce("", (a,b) -> a + b) );

		statement.append("You owed " + totalAmount + "\n");
		statement.append("You earned " + frequentRenterPoints + " frequent renter points\n");
		return statement.toString();
	}

	private String name;
	private Collection<Rental> rentals = new LinkedList<>();
}
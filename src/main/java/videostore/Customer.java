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

	public String statement () {
		var frequentRenterPoints = rentals.stream()
				.mapToInt(Rental::frequentRenterPoints)
				.sum();

		double totalAmount = rentals.stream()
				.mapToDouble(Rental::amount)
				.sum();

		return new StatementFormatter().format(rentals, name, frequentRenterPoints, totalAmount);
	}


	private String name;
	private Collection<Rental> rentals = new LinkedList<>();
}
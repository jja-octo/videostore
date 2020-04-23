package videostore;

import java.util.Collection;
import java.util.LinkedList;

public class Customer 
{

	private final StatementFormatter statementFormatter;

	public Customer (String name) {
		this.name = name;
		statementFormatter = new StatementFormatter();
	}
	
	public void addRental (Rental rental) {
		rentals.add(rental);
	}

	public String statement () {
		var frequentRenterPoints = rentals.stream()
				.mapToInt(Rental::frequentRenterPoints)
				.sum();

		var totalAmount = rentals.stream()
				.mapToDouble(Rental::amount)
				.sum();

		return statementFormatter.format(rentals, name, frequentRenterPoints, totalAmount);
	}


	private String name;
	private Collection<Rental> rentals = new LinkedList<>();
}
package videostore;

import java.util.Collection;

public class StatementFormatter {
    public String format(Collection<Rental> rentals, String customerName, int frequentRenterPoints, double totalAmount) {
   		var statement = new StringBuilder("Rental Record for " + customerName + "\n");
   		statement.append( rentals.stream()
   				.map(rental -> "\t" + rental.getMovie ().getTitle () + "\t"
   						+ rental.amount() + "\n")
   				.reduce("", (a,b) -> a + b) );
   
   		statement.append("You owed " + totalAmount + "\n");
   		statement.append("You earned " + frequentRenterPoints + " frequent renter points\n");
   		return statement.toString();
   	}
}

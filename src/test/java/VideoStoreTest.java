import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoStoreTest {
    final Customer customer = new Customer("Fred");

    @Test
    void oneRentalOneMovie() {
        Movie movie = new Movie("2001: A Space Odyssey", Movie.REGULAR);
        int daysRented = 5;
        customer.addRental(new Rental(movie, daysRented));

        assertThat(customer.statement()).isEqualTo("Rental Record for Fred\n" +
                "\t2001: A Space Odyssey\t6.5\n" +
                "You owed 6.5\n" +
                "You earned 1 frequent renter points\n");
    }
}
package videostore;

import org.junit.jupiter.api.Test;
import videostore.movie.Movie;
import videostore.movie.RegularMovie;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoStoreTest {
    final Customer customer = new Customer("Fred");

    @Test
    void oneRentalOneRegularMovie() {
        Movie movie = new RegularMovie("2001: A Space Odyssey");
        int daysRented = 5;
        customer.addRental(new Rental(movie, daysRented));

        assertThat(customer.statement()).isEqualTo("Rental Record for Fred\n" +
                "\t2001: A Space Odyssey\t6.5\n" +
                "You owed 6.5\n" +
                "You earned 1 frequent renter points\n");
    }

    @Test
    void twoRentalsOneMovie() {
        Movie movie = new RegularMovie("2001: A Space Odyssey");
        customer.addRental(new Rental(movie, 5));
        customer.addRental(new Rental(movie, 7));

        assertThat(customer.statement()).isEqualTo("Rental Record for Fred\n" +
                "\t2001: A Space Odyssey\t6.5\n" +
                "\t2001: A Space Odyssey\t9.5\n" +
                "You owed 16.0\n" +
                "You earned 2 frequent renter points\n");
    }
}
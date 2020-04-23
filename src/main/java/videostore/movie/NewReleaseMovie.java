package videostore.movie;

import videostore.Pricing;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title, Pricing.NEW_RELEASE);
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}

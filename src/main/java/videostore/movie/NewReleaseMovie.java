package videostore.movie;

import videostore.Pricing;

import static videostore.Pricing.NEW_RELEASE;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title, Pricing.NEW_RELEASE);
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        int renterPoints;
        if (this.getPricing() == NEW_RELEASE && daysRented > 1) {
            renterPoints = 2;
        } else {
            renterPoints = 1;
        }
        return renterPoints;
    }
}

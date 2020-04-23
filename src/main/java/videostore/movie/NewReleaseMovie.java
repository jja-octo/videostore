package videostore.movie;

import videostore.Pricing;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title, Pricing.NEW_RELEASE);
    }

    @Override
    protected double basePrice() {
        return 0;
    }

    @Override
    protected int daysPenalty() {
        return 0;
    }

    @Override
    protected double dailyPrice() {
        return 3;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}

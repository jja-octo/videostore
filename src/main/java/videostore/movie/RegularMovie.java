package videostore.movie;

import videostore.Pricing;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title, Pricing.REGULAR);
    }

    @Override
    protected double basePrice() {
        return 2;
    }

    @Override
    protected int daysPenalty() {
        return 2;
    }

    @Override
    protected double dailyPrice() {
        return 1.5;
    }

    @Override
    public int frequentRenterPoints(int daysRented) {
        return 1;
    }
    
}

package videostore.movie;

import videostore.Pricing;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title, Pricing.REGULAR);
    }

    @Override
    public double rentalAmount(int daysRented) {
        return pricing.rentalAmount(daysRented);
    }
    
    @Override
    public int frequentRenterPoints(int daysRented) {
        return 1;
    }
    
}

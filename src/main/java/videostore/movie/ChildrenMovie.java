package videostore.movie;

import videostore.Pricing;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title, Pricing.CHILDREN);
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

package videostore.movie;

import videostore.Pricing;

public abstract class Movie {
    private final String title;
    final Pricing pricing;

    Movie(String title, Pricing pricing) {
        this.title = title;
        this.pricing = pricing;
    }

    public static Movie build(String title, Pricing pricing) {
        switch (pricing) {
            case REGULAR:
                return new RegularMovie(title);
            case NEW_RELEASE:
                return new NewReleaseMovie(title);
            case CHILDREN:
                return new ChildrenMovie(title);
            default:
                throw new IllegalArgumentException();
        }
    }

    public double rentalAmount(int daysRented) {
        double regularAmountToAdd = basePrice();
        if (daysRented > daysPenalty()) {
            regularAmountToAdd += (daysRented - daysPenalty()) * dailyPrice();
        }
        return regularAmountToAdd;
   }

    protected abstract double basePrice();

    protected abstract int daysPenalty();

    protected abstract double dailyPrice();

    public abstract int frequentRenterPoints(int daysRented);

    public String getTitle() {
        return title;
    }

}
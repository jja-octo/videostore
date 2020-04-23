package videostore.movie;

public abstract class Movie {
    private final String title;

    Movie(String title) {
        this.title = title;
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
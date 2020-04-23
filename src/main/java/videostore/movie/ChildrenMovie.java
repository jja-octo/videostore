package videostore.movie;

public class ChildrenMovie extends Movie {

    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    protected double basePrice() {
        return 1.5;
    }

    @Override
    protected int daysPenalty() {
        return 3;
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

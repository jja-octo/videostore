package videostore.movie;

import videostore.Pricing;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title) {
        super(title, Pricing.CHILDREN);
    }
}

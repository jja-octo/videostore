package videostore.movie;

import videostore.Pricing;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title, Pricing.NEW_RELEASE);
    }
}

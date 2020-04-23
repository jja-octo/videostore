package videostore.movie;

import videostore.Pricing;

public class Movie
{

    private final String title;
	private final Pricing pricing;
	
	public Movie (String title, Pricing pricing) {
		this.title 		= title;
		this.pricing = pricing;
	}
	
	public Pricing getPricing() {
		return pricing;
	}

    public String getTitle () {
		return title;
	}
	
}
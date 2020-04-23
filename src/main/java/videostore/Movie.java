package videostore;

public class Movie
{
    public enum Pricing {
        REGULAR(0),
        NEW_RELEASE(1),
        CHILDREN(2),
        ;

        private final int code;

        Pricing(int code) {
            this.code = code;
        }
        public String code() {
            return String.valueOf(code);
        }
    } 
	
	private String title;
	private Pricing pricing;
	
	public Movie (String title, Pricing pricing) {
		this.title 		= title;
		this.pricing = pricing;
	}
	
	public Pricing getPricing() {
		return pricing;
	}
	
	public void setPricing(Pricing code) {
		pricing = code;
	}
	
	public String getTitle () {
		return title;
	}
	
}
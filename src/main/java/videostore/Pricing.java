package videostore;

public enum Pricing {
    REGULAR(0, 2, 2, 1.5),
    NEW_RELEASE(1, 0, 0, 3),
    CHILDREN(2, 1.5, 3, 1.5),
    ;

    private final int code;
    private final double basePrice;
    private final int daysPenalty;
    private final double dailyPrice;

    Pricing(int code, double basePrice, int daysPenalty, double dailyPrice) {
        this.code = code;
        this.basePrice = basePrice;
        this.daysPenalty = daysPenalty;
        this.dailyPrice = dailyPrice;
    }

    public double computeAmount(int daysRented) {
        double regularAmountToAdd = basePrice;
        if (daysRented > daysPenalty) {
            regularAmountToAdd += (daysRented - daysPenalty) * dailyPrice;
        }
        return regularAmountToAdd;
    }

    public String code() {
        return String.valueOf(code);
    }
}

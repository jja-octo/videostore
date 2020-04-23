package videostore;

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

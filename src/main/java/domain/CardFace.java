package domain;

public enum CardFace {

    KING("K"),
    QUEEN("Q"),
    JACK("J"),
    NONE("");

    private String name;
    CardFace(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isNone() {
        return this.equals(NONE);
    }
}

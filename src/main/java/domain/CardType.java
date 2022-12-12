package domain;

public enum CardType {
    CLOVER("클로버"),
    HEART("하트"),
    SPADE("스페이드"),
    DIAMOND("다이아몬드");

    private final String name;
    CardType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isSpade() {
        return this.equals(SPADE);
    }
}

package domain.Card;

public class Card {

    private final Denomination denomination;
    private final Suit suit;

    public Card(Denomination denomination, Suit suit) {
        this.denomination = denomination;
        this.suit = suit;
    }

    public boolean isAce() {
        return this.denomination.isAce();
    }

    public int getScore() {
        return this.denomination.getScore();
    }
}

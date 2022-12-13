package domain;

import java.util.List;

public abstract class AbstractPlayer {
    private final Cards cards;

    protected AbstractPlayer(List<Card> cardList) {
        cards = new Cards(cardList);
    }

    public List<Card> getCards() {
        return cards;
    }
}

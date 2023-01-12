package domain.State;

import domain.Card.Cards;

public abstract class Started implements State {
    protected final Cards cards;

    protected Started(Cards cards) {
        this.cards = cards;
    }

    @Override
    public Cards cards() {
        return cards;
    }
}

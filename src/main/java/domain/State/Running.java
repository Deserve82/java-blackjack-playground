package domain.State;

import domain.Card.Cards;

public abstract class Running extends Started implements State {

    protected Running(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

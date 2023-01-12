package domain.Player;

import domain.Card.Card;
import domain.State.State;

public abstract class AbstractPlayer {

    private final State state;

    AbstractPlayer(State state) {
        this.state = state;
    }

    public void draw(Card card) {
        state.draw(card);
    }
}

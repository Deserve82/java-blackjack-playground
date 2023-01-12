package domain.State;

import domain.Card.Card;
import domain.Card.Cards;

public interface State {
    State draw(Card card);
    State stay();
    boolean isFinished();
    Cards cards();
}

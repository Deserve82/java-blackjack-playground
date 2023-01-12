package domain.State;

import domain.Card.Card;
import domain.Card.Cards;

public class Hit extends Running {

    public Hit(Cards cards) {
        super(cards);
    }

    @Override
    public State draw(Card card) {
        cards.addCard(card);
        int score = cards.getSumScore();
        if (score > 21) {
            return new Bust(cards);
        }
        return new Hit(cards);
    }

    @Override
    public State stay() {
        return new Stay(cards);
    }
}

package domain;

import java.util.ArrayList;
import java.util.List;

public class Player extends AbstractPlayer {

    public Player(List<Card> cardList) {
        super(cardList);
    }

    public Player() {
        super(new ArrayList<>());
    }

    public boolean isDoubleBlackJack() {
        return getCards().size() == 2 && isBlackJack();
    }
}

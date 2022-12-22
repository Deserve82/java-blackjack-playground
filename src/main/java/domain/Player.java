package domain;

import java.util.ArrayList;
import java.util.List;

public class Player extends AbstractPlayer {

    private final String name;

    public Player(List<Card> cardList, String name) {
        super(cardList);
        this.name = name;
    }

    public Player(List<Card> cardList) {
        this(cardList, "");
    }

    public Player() {
        this(new ArrayList<>(), "");
    }

    public boolean isDoubleBlackJack() {
        return getCards().size() == 2 && isBlackJack();
    }

    public String getName() {
        return name;
    }
}

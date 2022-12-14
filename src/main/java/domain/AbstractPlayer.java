package domain;

import java.util.List;

public abstract class AbstractPlayer {
    private final Cards cards;

    protected AbstractPlayer(List<Card> cardList) {
        cards = new Cards(cardList);
    }

    public List<Card> getCards() {
        return cards.getCardList();
    }

    public void addCard(Card card) {
        cards.addCard(card);
    };

    public boolean isBust(){
        return cards.getValueSum() > 21;
    };

    public boolean isBlackJack(){
        return cards.getValueSum() == 21;
    };
}

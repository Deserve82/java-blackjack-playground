package domain;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private final List<Card> cardList;

    public Cards(List<Card> cardList) {
        this.cardList = cardList;
    }

    public Cards() {
        this(new ArrayList<>());
    }

    public int getValueSum() {
        if (containAce()) {
            int totalSum = getTotalSum();
            return getAppropriateAceValue(totalSum);
        }
        return getTotalSum();
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public int size() {
        return cardList.size();
    }

    private boolean containAce() {
        return cardList.stream().anyMatch(Card::isAce);
    }

    private int getTotalSum() {
        return cardList.stream().map(Card::getValue).reduce(0, Integer::sum);
    }

    private int getAppropriateAceValue(int sum) {
        int aceValue11 = sum + 10;
        if (aceValue11 > 21) {
            return sum;
        }
        return aceValue11;
    }

    public void addCard(Card card) {
        cardList.add(card);
    }

    public Card pop() {
        return cardList.remove(size() - 1);
    }
}

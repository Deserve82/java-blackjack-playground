package domain.Card;

import java.util.ArrayList;
import java.util.List;

public class Cards {

    private final List<Card> cardList;

    public Cards(List<Card> cardList) {
        this.cardList = new ArrayList(cardList);
    }

    public int getSumScore() {
        int sumValue = getTotalScore();
        if (containsAce()) {
            return checkAceValue(sumValue);
        }

        return sumValue;
    }

    private int checkAceValue(int sum) {
        if (sum + 10 <= 21) {
            return sum + 10;
        }
        return sum;
    }

    private int getTotalScore() {
        return cardList.stream().map(Card::getScore).reduce(0, Integer::sum);
    }

    private boolean containsAce() {
        return cardList.stream().map(Card::isAce).findAny().orElse(false);
    }

    public boolean isBlackJack() {
        return 21 == getSumScore();
    }

    public int size() {
        return cardList.size();
    }

    public void addCard(Card card) {
        cardList.add(card);
    }
}

package domain;

import java.util.List;

public class Cards {

    private final List<Card> cardList;

    public Cards(List<Card> cardList) {
        this.cardList = cardList;
    }

    public int getValueSum() {
        if (containAce()) {
            int totalSum = getTotalSum();
            return getAppropriateAceValue(totalSum);
        }
        return getTotalSum();
    }

    private boolean containAce() {
        return cardList.stream().map(Card::isAce).findAny().orElse(false);
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
}

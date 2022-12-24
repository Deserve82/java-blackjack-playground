package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final Cards cards;
    private static final int NUMBER_OF_CARD = 10;

    public Deck() {
        List<Card> cardList = new ArrayList<>();
        Arrays.stream(CardType.values()).forEach(type -> createCard(cardList, type));

        Collections.shuffle(cardList);

        cards = new Cards(cardList);
    }

    private void createCard(List<Card> cardList, CardType type) {
        Arrays.stream(CardFace.values())
                .filter(face -> !face.isNone())
                .forEach(face -> cardList.add(new Card(face, type)));

        for (int num = 1; num <= NUMBER_OF_CARD; num++) {
            cardList.add(new Card(CardFace.NONE, type, num));
        }
    }

    public int size() {
        return this.cards.size();
    }

    public Cards getCards() {
        return cards;
    }

    public Card pop() {
        return cards.pop();
    }
}

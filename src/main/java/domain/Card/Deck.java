package domain.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {

    private final ArrayList<Card> cards = new ArrayList<>();

    public Deck() {
        Arrays.stream(Denomination.values()).forEach(this::addCard);
        Collections.shuffle(cards);
    }

    private void addCard(Denomination denomination) {
        Arrays.stream(Suit.values()).forEach(suit -> cards.add(new Card(denomination, suit)));
    }

    public int size() {
        return cards.size();
    }

    public Card pop() {
        return cards.remove(size() - 1);
    }
}

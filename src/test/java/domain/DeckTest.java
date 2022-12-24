package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void create() {
        Deck deck = new Deck();

        assertThat(deck.size()).isEqualTo(52);
        assertThat(deck.getCards().getCardList().stream().distinct().count()).isEqualTo(52);
    }

    @Test
    void pop() {
        Deck deck = new Deck();

        Card a = deck.pop();
        Card b = deck.pop();

        System.out.println(a);
        System.out.println(b);

        assertThat(a).isNotEqualTo(b);
        assertThat(deck.getCards().getCardList().stream().distinct().count()).isEqualTo(50);
    }
}

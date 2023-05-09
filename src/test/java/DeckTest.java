import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Card.Deck;
import org.junit.jupiter.api.Test;

class DeckTest {

    @Test
    void create() {
        assertDoesNotThrow(Deck::new);
    }

    @Test
    void size() {
        Deck deck = new Deck();
        assertThat(deck.size()).isEqualTo(52);
    }

    @Test
    void pop() {
        Deck deck = new Deck();
        assertThat(deck.pop() != null).isTrue();
    }
}

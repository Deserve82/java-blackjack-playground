import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Card;
import domain.Denomination;
import domain.Suit;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void creat() {
        assertDoesNotThrow(() -> new Card(Denomination.EIGHT, Suit.CLUBS));
    }

    @Test
    void isAce() {
        Card card = new Card(Denomination.ACE, Suit.SPADES);
        assertThat(card.isAce()).isTrue();
    }
}

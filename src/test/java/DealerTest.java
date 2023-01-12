import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Card.Card;
import domain.Card.Cards;
import domain.Card.Denomination;
import domain.Card.Suit;
import domain.Player.Dealer;
import domain.State.State;
import domain.State.Stay;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class DealerTest {

    private final State stay = new Stay(new Cards(
            Arrays.asList(
                    new Card(Denomination.EIGHT, Suit.SPADES),
                    new Card(Denomination.SEVEN, Suit.SPADES)
            )));

    @Test
    void create() {
        assertDoesNotThrow(() -> new Dealer(stay));
    }
}

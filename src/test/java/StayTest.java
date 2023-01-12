import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Card.Card;
import domain.Card.Cards;
import domain.Card.Denomination;
import domain.Card.Suit;
import domain.CompareResult;
import domain.State.Stay;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class StayTest {

    private final Cards cards = new Cards(Arrays.asList(
            new Card(Denomination.QUEEN, Suit.SPADES),
            new Card(Denomination.FOUR, Suit.DIAMOND)
    ));

    @Test
    void create() {
        assertDoesNotThrow(() -> new Stay(new Cards(new ArrayList<>())));
    }

    @Test
    void earnRate() {
        Stay state = new Stay(new Cards(new ArrayList<>()));
        assertThat(state.earnRate()).isEqualTo(1.0);
    }
}

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Card.Card;
import domain.Card.Cards;
import domain.Card.Denomination;
import domain.Card.Suit;
import domain.State.Bust;
import domain.State.Hit;
import domain.State.Stay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class HitTest {

    @Test
    void create() {
        assertDoesNotThrow(() -> new Hit(new Cards(new ArrayList<>())));
    }

    @Test
    void drawCardWhenBust() {
        Hit state = new Hit(new Cards(Arrays.asList(
                new Card(Denomination.QUEEN, Suit.DIAMOND),
                new Card(Denomination.QUEEN, Suit.HEARTS))));
        assertThat(state.draw(new Card(Denomination.TWO, Suit.CLUBS)) instanceof Bust).isTrue();
    }

    @Test
    void drawCardWhenHit() {
        Hit state = new Hit(new Cards(
                Collections.singletonList(new Card(Denomination.TWO, Suit.HEARTS))));
        assertThat(state.draw(new Card(Denomination.FIVE, Suit.SPADES)) instanceof Hit).isTrue();
    }

    @Test
    void stay() {
        Hit state = new Hit(new Cards(new ArrayList<>()));
        assertThat(state.stay() instanceof Stay).isTrue();
    }

}

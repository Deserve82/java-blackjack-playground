import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Card.Card;
import domain.Card.Cards;
import domain.Card.Denomination;
import domain.Card.Suit;
import domain.CompareResult;
import domain.State.BlackJack;
import domain.State.Bust;
import domain.State.Stay;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class StayTest {

    private final Cards cards = new Cards(Arrays.asList(
            new Card(Denomination.QUEEN, Suit.SPADES),
            new Card(Denomination.FOUR, Suit.DIAMOND)
    ));

    private final Cards cards2 = new Cards(Arrays.asList(
            new Card(Denomination.QUEEN, Suit.SPADES),
            new Card(Denomination.FOUR, Suit.DIAMOND),
            new Card(Denomination.THREE, Suit.DIAMOND)
    ));

    private final Cards bustCards = new Cards(Arrays.asList(
            new Card(Denomination.QUEEN, Suit.SPADES),
            new Card(Denomination.KING, Suit.DIAMOND),
            new Card(Denomination.THREE, Suit.DIAMOND)
    ));

    private final Cards blackJackCards = new Cards(Arrays.asList(
            new Card(Denomination.ACE, Suit.SPADES),
            new Card(Denomination.KING, Suit.CLUBS)
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

    @Test
    void compareLose() {
        Stay state = new Stay(cards);
        Stay state2 = new Stay(cards2);

        assertThat(state.compare(state2)).isEqualTo(CompareResult.LOSE);
    }

    @Test
    void compareDraw() {
        Stay state = new Stay(cards);
        Stay state2 = new Stay(cards);

        assertThat(state.compare(state2)).isEqualTo(CompareResult.DRAW);
    }

    @Test
    void compareWin() {
        Stay state = new Stay(cards2);
        Stay state2 = new Stay(cards);

        assertThat(state.compare(state2)).isEqualTo(CompareResult.WIN);
    }

    @Test
    void compareBlackJack() {
        Stay stay = new Stay(cards);
        BlackJack blackJack = new BlackJack(blackJackCards);

        assertThat(stay.compare(blackJack)).isEqualTo(CompareResult.LOSE);
    }

    @Test
    void compareBust() {
        Stay stay = new Stay(cards);
        Bust bust = new Bust(bustCards);

        assertThat(stay.compare(bust)).isEqualTo(CompareResult.WIN);
    }
}

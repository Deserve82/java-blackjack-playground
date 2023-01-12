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

class BustTest {

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
        assertDoesNotThrow(() -> new Bust(new Cards(new ArrayList<>())));
    }

    @Test
    void earnRate() {
        Bust state = new Bust(new Cards(new ArrayList<>()));
        assertThat(state.earnRate()).isEqualTo(-1.0);
    }

    @Test
    void compareBust() {
        Bust bust = new Bust(bustCards);
        Bust opponent = new Bust(bustCards);
        assertThat(bust.compare(opponent)).isEqualTo(CompareResult.LOSE);
    }

    @Test
    void compareStay() {
        Bust bust = new Bust(bustCards);
        Stay opponent = new Stay(cards2);
        assertThat(bust.compare(opponent)).isEqualTo(CompareResult.LOSE);
    }

    @Test
    void compareBlackJack() {
        Bust bust = new Bust(bustCards);
        BlackJack opponent = new BlackJack(cards2);
        assertThat(bust.compare(opponent)).isEqualTo(CompareResult.LOSE);
    }
}

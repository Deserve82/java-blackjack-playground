import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Card.Card;
import domain.Card.Cards;
import domain.Card.Denomination;
import domain.Card.Suit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class CardsTest {


    @Test
    void create() {
        assertDoesNotThrow(() -> new Cards(Collections.emptyList()));
    }

    @Test
    void isBlackJack() {
        Cards cards = new Cards(Arrays.asList(new Card(Denomination.ACE, Suit.CLUBS), new Card(Denomination.QUEEN, Suit.HEARTS)));
        assertThat(cards.isBlackJack()).isTrue();
    }

    @Test
    void getSumScore() {
        Cards cards = new Cards(Arrays.asList(new Card(Denomination.ACE, Suit.CLUBS), new Card(Denomination.QUEEN, Suit.HEARTS)));
        Cards cards1 = new Cards(Arrays.asList(new Card(Denomination.EIGHT, Suit.CLUBS), new Card(Denomination.QUEEN, Suit.HEARTS)));
        Cards cards2 = new Cards(Arrays.asList(new Card(Denomination.ACE, Suit.CLUBS), new Card(Denomination.QUEEN, Suit.HEARTS), new Card(Denomination.EIGHT, Suit.CLUBS)));
        assertThat(cards.getSumScore()).isEqualTo(21);
        assertThat(cards1.getSumScore()).isEqualTo(18);
        assertThat(cards2.getSumScore()).isEqualTo(19);
    }

    @Test
    void addCard() {
        Cards cards = new Cards(new ArrayList<>());
        cards.addCard(new Card(Denomination.ACE, Suit.CLUBS));
        assertThat(cards.size()).isEqualTo(1);
    }
}

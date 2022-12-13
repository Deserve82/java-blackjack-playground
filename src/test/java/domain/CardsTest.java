package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CardsTest {
    @Test
    void create() {
        Card clover2 = new Card(CardFace.NONE, CardType.CLOVER, 2);
        Card heart5 = new Card(CardFace.NONE, CardType.HEART, 5);
        assertDoesNotThrow(() -> new Cards(Arrays.asList(clover2, heart5)));
    }

    @Test
    void getValueSum() {
        Card clover2 = new Card(CardFace.NONE, CardType.CLOVER, 2);
        Card heart5 = new Card(CardFace.NONE, CardType.HEART, 5);
        Cards cards = new Cards(Arrays.asList(clover2, heart5));
        assertThat(cards.getValueSum()).isEqualTo(7);
    }

    @Test
    void getValueSumWithAce() {
        Card ace = new Card(CardFace.NONE, CardType.SPADE, 1);
        Card heartJack = new Card(CardFace.JACK, CardType.HEART);
        Cards cards = new Cards(Arrays.asList(ace, heartJack));
        assertThat(cards.getValueSum()).isEqualTo(21);
    }

    @Test
    void getClosestValueWithAce2() {
        Card ace = new Card(CardFace.NONE, CardType.SPADE, 1);
        Card heartJack = new Card(CardFace.KING, CardType.DIAMOND);
        Card clover2 = new Card(CardFace.NONE, CardType.CLOVER, 2);

        Cards cards = new Cards(Arrays.asList(ace, heartJack, clover2));
        assertThat(cards.getValueSum()).isEqualTo(13);
    }

}

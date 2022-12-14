package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    void create() {
        assertDoesNotThrow(() -> new Card(CardFace.NONE, CardType.HEART, 3));
        assertDoesNotThrow(() -> new Card(CardFace.JACK, CardType.HEART));
    }

    @Test
    void invalidCreate() {
        assertThrows(InvalidParameterException.class, () -> new Card(CardFace.NONE, CardType.CLOVER, 11));
        assertThrows(InvalidParameterException.class, () -> new Card(CardFace.KING, CardType.CLOVER, 9));
    }

    @Test
    void isAce() {
        Card card = new Card(CardFace.NONE, CardType.SPADE, 1);
        assertThat(card.isAce()).isTrue();
    }

    @Test
    void isNotAce() {
        Card card = new Card(CardFace.JACK, CardType.HEART);
        assertThat(card.isAce()).isFalse();
    }

    @Test
    void toStringTest() {
        Card card = new Card(CardFace.KING, CardType.DIAMOND);
        assertThat(card.toString()).isEqualTo("K다이아몬드");

        Card card1 = new Card(CardFace.NONE, CardType.CLOVER, 6);
        assertThat(card1.toString()).isEqualTo("6클로버");
    }

    @Test
    void getValue() {
        Card card = new Card(CardFace.JACK, CardType.DIAMOND);
        assertThat(card.getValue()).isEqualTo(10);
    }

}

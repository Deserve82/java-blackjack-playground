package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PlayerTest {

    @Test
    void create() {
        assertDoesNotThrow(() -> new Player(Collections.singletonList(new Card(CardFace.KING, CardType.CLOVER))));
    }

    @Test
    void getCards() {
        Card ace = new Card(CardFace.NONE, CardType.SPADE, 1);
        Card kingHeart = new Card(CardFace.KING, CardType.HEART);
        Player a = new Player(Arrays.asList(ace, kingHeart));

        assertThat(a.getCards().get(0)).isEqualTo(ace);
        assertThat(a.getCards().get(1)).isEqualTo(kingHeart);
    }

    @Test
    void addCard() {
        Player a = new Player();
        Card card = new Card(CardFace.JACK, CardType.CLOVER);
        a.addCard(card);

        assertThat(a.getCards().get(0)).isEqualTo(card);
    }

    @Test
    void isBust() {
        Player a = new Player(Arrays.asList(
                new Card(CardFace.KING, CardType.DIAMOND),
                new Card(CardFace.JACK, CardType.DIAMOND),
                new Card(CardFace.NONE, CardType.CLOVER, 3)
        ));

        assertThat(a.isBust()).isTrue();
    }

    @Test
    void isBlackJack() {
        Player a = new Player(Arrays.asList(
                new Card(CardFace.KING, CardType.CLOVER),
                new Card(CardFace.NONE, CardType.SPADE, 1)));

        assertThat(a.isBlackJack()).isTrue();
    }
}

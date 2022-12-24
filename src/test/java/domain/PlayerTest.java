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
                new Card(CardFace.NONE, CardType.SPADE, 3),
                new Card(CardFace.NONE, CardType.SPADE, 8)));

        assertThat(a.isBlackJack()).isTrue();
    }

    @Test
    void increasePossession() {
        Player a = new Player();
        a.increasePossession(1000);
        assertThat(a.getPossession()).isEqualTo(1000);
    }

    @Test
    void decreasePossession() {
        Player a = new Player();
        a.decreasePossession(1000);
        assertThat(a.getPossession()).isEqualTo(-1000);
    }

    @Test
    void isDoubleBlackJack() {
        Player a = new Player(Arrays.asList(
                new Card(CardFace.KING, CardType.CLOVER),
                new Card(CardFace.NONE, CardType.SPADE, 1)));

        assertThat(a.isDoubleBlackJack()).isTrue();
    }

    @Test
    void isBigger() {
        Player a = new Player(Arrays.asList(
                new Card(CardFace.NONE, CardType.SPADE, 1),
                new Card(CardFace.KING, CardType.SPADE)
        ));

        Player b = new Player(Arrays.asList(
                new Card(CardFace.NONE, CardType.HEART, 1),
                new Card(CardFace.KING, CardType.HEART)
        ));

        assertThat(a.isBigger(b)).isTrue();
    }

    @Test
    void isSame() {
        Player a = new Player(Arrays.asList(
                new Card(CardFace.NONE, CardType.CLOVER, 1),
                new Card(CardFace.KING, CardType.CLOVER)
        ));

        Player b = new Player(Arrays.asList(
                new Card(CardFace.NONE, CardType.HEART, 1),
                new Card(CardFace.KING, CardType.HEART)
        ));

        assertThat(a.isSame(b)).isTrue();
    }
}

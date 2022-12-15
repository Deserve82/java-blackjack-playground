package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DealerTest {

    private final List<Card> cards20 = Arrays.asList(
            new Card(CardFace.KING, CardType.HEART),
            new Card(CardFace.JACK, CardType.SPADE));

    private final List<Card> cards19 = Arrays.asList(
            new Card(CardFace.NONE, CardType.HEART, 2),
            new Card(CardFace.JACK, CardType.SPADE),
            new Card(CardFace.NONE, CardType.DIAMOND, 7));

    private final List<Card> cards21 = Arrays.asList(
            new Card(CardFace.QUEEN, CardType.SPADE),
            new Card(CardFace.NONE, CardType.SPADE, 1));

    @Test
    void create() {
        assertDoesNotThrow(Dealer::new);
    }

    @Test
    void checkPlayer() {
        Player a = new Player(cards20);
        Player b = new Player(cards21);

        List<Player> playerList = Arrays.asList(a, b);

    }
}

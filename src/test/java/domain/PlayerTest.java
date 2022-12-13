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
}

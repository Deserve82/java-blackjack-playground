package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
    void checkPlayer() {
        Player player19 = new Player(cards19);
        Player player21 = new Player(cards21);

        HashMap<Player, Money> playerList = new HashMap<Player, Money>() {
            {
                put(player19, new Money(100));
                put(player21, new Money(200));
            }
        };
        Dealer dealer = new Dealer(cards20, playerList);

        dealer.checkPlayers();

        assertThat(player19.getPossession()).isEqualTo(-100);
        assertThat(player21.getPossession()).isEqualTo(300);
        assertThat(dealer.getPossession()).isEqualTo(-200);
    }
}

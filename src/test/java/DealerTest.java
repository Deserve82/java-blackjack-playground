import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Card.Card;
import domain.Card.Cards;
import domain.Card.Denomination;
import domain.Card.Suit;
import domain.Player.Dealer;
import domain.Player.Player;
import domain.State.BlackJack;
import domain.State.Bust;
import domain.State.State;
import domain.State.Stay;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class DealerTest {

    private final State stay = new Stay(new Cards(
            Arrays.asList(
                    new Card(Denomination.EIGHT, Suit.SPADES),
                    new Card(Denomination.NINE, Suit.SPADES)
            )));

    private final State stay2 = new Stay(new Cards(
            Arrays.asList(
                    new Card(Denomination.NINE, Suit.HEARTS),
                    new Card(Denomination.NINE, Suit.SPADES)
            )));

    private final State blackJack = new BlackJack(new Cards(
            Arrays.asList(
                    new Card(Denomination.ACE, Suit.SPADES),
                    new Card(Denomination.KING, Suit.SPADES)
            )));

    private final State bust = new Bust(new Cards(new ArrayList<>()));



    @Test
    void create() {
        assertDoesNotThrow(() -> new Dealer(stay));
    }

    @Test
    void compareWhenWin() {
        Dealer dealer = new Dealer(blackJack);
        List<Player> players = Collections.singletonList(new Player(stay, "test", 100));
        dealer.compare(players);

        assertThat(players.get(0).getPossession()).isEqualTo(-150);
    }

    @Test
    void compareWhenDraw() {
        Dealer dealer = new Dealer(blackJack);
        List<Player> players = Collections.singletonList(new Player(blackJack, "test", 100));
        dealer.compare(players);

        assertThat(players.get(0).getPossession()).isEqualTo(100);
    }

    @Test
    void compareWhenLose() {
        Dealer dealer = new Dealer(stay);
        List<Player> players = Collections.singletonList(new Player(stay2, "test", 100));
        dealer.compare(players);

        assertThat(players.get(0).getPossession()).isEqualTo(100);
    }

    @Test
    void compareWhenBust() {
        Dealer dealer = new Dealer(bust);
        List<Player> players = Collections.singletonList(new Player(bust, "test", 100));
        dealer.compare(players);

        assertThat(players.get(0).getPossession()).isEqualTo(100);
    }

    @Test
    void isUnder16() {
        Dealer dealer = new Dealer(stay);

        assertThat(dealer.isUnder16()).isFalse();
    }

}

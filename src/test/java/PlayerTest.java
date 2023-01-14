import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Card.Card;
import domain.Card.Cards;
import domain.Card.Denomination;
import domain.Card.Suit;
import domain.Player.Money;
import domain.Player.Player;
import domain.State.Hit;
import domain.State.State;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private final State hit = new Hit(new Cards(Arrays.asList(
            new Card(Denomination.QUEEN, Suit.SPADES),
            new Card(Denomination.EIGHT, Suit.CLUBS)
    )));

    @Test
    void create() {
        assertDoesNotThrow(() -> new Player(hit, "test"));
    }

    @Test
    void getName() {
        Player player = new Player(hit, "test");
        assertThat(player.getName()).isEqualTo("test");
    }

    @Test
    void updatePossession() {
        Player player = new Player(hit, "test", 0);
        player.updatePossession(new Money(200));
        assertThat(player.getPossession()).isEqualTo(200);

        player.updatePossession(new Money(1));
        assertThat(player.getPossession()).isEqualTo(201);
    }
}

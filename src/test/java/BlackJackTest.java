import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Card.Cards;
import domain.CompareResult;
import domain.State.BlackJack;
import domain.State.Stay;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class BlackJackTest {

    private final Cards cards = new Cards(new ArrayList<>());

    @Test
    void createTest() {
        assertDoesNotThrow(() -> new BlackJack(cards));
    }

    @Test
    void earnRate() {
        BlackJack state = new BlackJack(cards);
        assertThat(state.earnRate()).isEqualTo(1.5);
    }

    @Test
    void compare() {
        BlackJack state = new BlackJack(cards);
        BlackJack opponent1 = new BlackJack(cards);
        Stay opponent2 = new Stay(cards);

        assertThat(state.compare(opponent1)).isEqualTo(CompareResult.DRAW);
        assertThat(state.compare(opponent2)).isEqualTo(CompareResult.WIN);
    }

}

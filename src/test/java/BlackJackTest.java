import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Card.Cards;
import domain.State.BlackJack;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class BlackJackTest {

    @Test
    void createTest() {
        assertDoesNotThrow(() -> new BlackJack(new Cards(new ArrayList<>())));
    }

    @Test
    void earnRate() {
        BlackJack state = new BlackJack(new Cards(new ArrayList<>()));
        assertThat(state.earnRate()).isEqualTo(1.5);
    }

}

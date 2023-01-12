import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Card.Cards;
import domain.State.Bust;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class BustTest {

    @Test
    void create() {
        assertDoesNotThrow(() -> new Bust(new Cards(new ArrayList<>())));
    }

    @Test
    void earnRate() {
        Bust state = new Bust(new Cards(new ArrayList<>()));
        assertThat(state.earnRate()).isEqualTo(-1.0);
    }

}

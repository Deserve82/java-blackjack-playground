import static org.assertj.core.api.Assertions.assertThat;

import domain.Card.Denomination;
import org.junit.jupiter.api.Test;

public class DenominationTest {

    @Test
    void isAce() {
        assertThat(Denomination.ACE.isAce()).isTrue();
        assertThat(Denomination.QUEEN.isAce()).isFalse();
    }

    @Test
    void getScore() {
        assertThat(Denomination.KING.getScore()).isEqualTo(10);
    }
}

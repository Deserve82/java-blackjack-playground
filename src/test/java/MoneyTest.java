import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.Player.Money;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void create() {
        assertDoesNotThrow(() -> new Money(300));
    }

    @Test
    void update() {
        Money money = new Money();

        Money changedMoney = money.update(new Money(100));

        assertThat(changedMoney).isEqualTo(new Money(100));
    }
}

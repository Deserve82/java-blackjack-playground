package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MoneyTest {

    @Test
    void create() {
        assertDoesNotThrow(() -> new Money());
    }

    @Test
    void increase() {
        Money a = new Money();

        assertThat(a.increase(100)).isEqualTo(new Money(100));
    }

    @Test
    void decrease() {
        Money a = new Money();
        assertThat(a.decrease(100)).isEqualTo(new Money(-100));
    }

    @Test
    void initialize() {
        Money a = new Money(100);
        assertThat(a.initialize()).isEqualTo(new Money());
    }

    @Test
    void isBigger() {
        Money a = new Money(100);
        Money smaller = new Money(10);
        assertThat(a.isBigger(smaller)).isTrue();
    }

    @Test
    void isSmaller() {
        Money a = new Money(100);
        Money smaller = new Money(10);
        assertThat(smaller.isSmaller(a)).isTrue();
    }

    @Test
    void getMultipleValue() {
        Money a = new Money(100);
        Money multiplied = a.multiplied(1.5);
        assertThat(multiplied).isEqualTo(new Money(150));
    }
}

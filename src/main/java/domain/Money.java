package domain;

import java.util.Objects;

public class Money {

    private final int value;

    public Money(int value) {
        this.value = value;
    }

    public Money() {
        this(0);
    }

    public Money increase(int money) {
        return new Money(value + money);
    }

    public Money decrease(int money) {
        return new Money(value - money);
    }

    public Money initialize() {
        return new Money();
    }

    public int getMoney() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean isBigger(Money money) {
        return this.value > money.value;
    }

    public boolean isSmaller(Money money) {
        return this.value < money.value;
    }
}

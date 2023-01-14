package domain.Player;

import java.util.Objects;

public class Money {
    private final double money;

    public Money(double money) {
        this.money = money;
    }

    public Money() {
        this(0);
    }

    public Money update(Money value) {
        return new Money(money + value.money);
    }

    public Money multiply(double value) {
        return new Money(money * value);
    }

    public double getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}

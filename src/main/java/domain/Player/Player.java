package domain.Player;

import domain.State.State;

public class Player extends AbstractPlayer {

    private final String name;
    private final Money betting;

    public Player(State state, String name, Money betting) {
        super(state);
        this.name = name;
        this.betting = betting;
    }

    public Player(State state, String name) {
        this(state, name, new Money());
    }

    public Player(State state, String name, int value) {
        this(state, name, new Money(value));
    }

    public String getName() {
        return name;
    }

    public Money getBetting() {
        return betting;
    }
}

package domain.Player;

import domain.State.State;

public class Player extends AbstractPlayer {

    private final String name;

    public Player(State state, String name) {
        super(state);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

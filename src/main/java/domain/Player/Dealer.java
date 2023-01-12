package domain.Player;

import domain.CompareResult;
import domain.State.State;

public class Dealer extends AbstractPlayer{

    public Dealer(State state) {
        super(state);
    }

    public CompareResult compare(Player playerA) {
        return CompareResult.LOSE;
    }
}

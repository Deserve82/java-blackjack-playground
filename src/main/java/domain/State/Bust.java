package domain.State;

import domain.Card.Cards;
import domain.CompareResult;

public class Bust extends Finished{

    public Bust(Cards cards) {
        super(cards);
    }

    @Override
    public double earnRate() {
        return -1.0;
    }

    public CompareResult compare(Finished state) {
        return null;
    }

}

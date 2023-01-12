package domain.State;

import domain.Card.Cards;
import domain.CompareResult;

public class Stay extends Finished {

    public Stay(Cards cards) {
        super(cards);
    }

    public double earnRate() {
        return 1.0;
    }
}

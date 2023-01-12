package domain.State;

import domain.Card.Cards;
import domain.CompareResult;

public class BlackJack extends Finished{

    public BlackJack(Cards cards) {
        super(cards);
    }

    @Override
    public double earnRate() {
        return 1.5;
    }

    public CompareResult compare(Finished state) {
        return null;
    }

}

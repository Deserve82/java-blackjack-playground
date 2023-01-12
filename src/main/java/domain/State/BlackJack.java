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

    @Override
    public CompareResult compare(Finished opponent) {
        if (opponent instanceof BlackJack) {
            return CompareResult.DRAW;
        }

        return CompareResult.WIN;
    }
}

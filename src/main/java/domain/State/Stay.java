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

    public int getScore(){
        return cards.getSumScore();
    }

    private CompareResult compareStay(Stay opponent) {
        if (getScore() > opponent.getScore()) {
            return CompareResult.WIN;
        }
        if (getScore() == opponent.getScore()) {
            return CompareResult.DRAW;
        }
        return CompareResult.LOSE;
    }

    @Override
    public CompareResult compare(Finished opponent) {
        if (opponent instanceof BlackJack) {
            return CompareResult.LOSE;
        }

        if (opponent instanceof Bust) {
            return CompareResult.WIN;
        }

        return compareStay((Stay) opponent);
    }
}

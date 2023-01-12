package domain.State;

import domain.Card.Card;
import domain.Card.Cards;
import domain.CompareResult;

public abstract class Finished extends Started {

    private static final String CAN_NOT_DRAW_WHEN_FINISHED_STATE = "더 이상 뽑을 수 없습니다.";

    protected Finished(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public State stay() {
        return this;
    }

    @Override
    public State draw(Card card) {
        throw new IllegalStateException(CAN_NOT_DRAW_WHEN_FINISHED_STATE);
    }

    public abstract double earnRate();

    public abstract CompareResult compare(Finished opponent);
}

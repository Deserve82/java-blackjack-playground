package domain;

public abstract class Running extends Started implements State {

    protected Running(Cards cards) {
        super(cards);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public double profit(double value) {
        if (this.cards.isBlackJack() && cards.size() == 2) {
            return value * 1.5;
        }

        return value;
    }
}

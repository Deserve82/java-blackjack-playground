package domain.Player;

import domain.Card.Card;
import domain.State.State;

public abstract class AbstractPlayer {

    protected final State state;

    protected Money possession = new Money();

    AbstractPlayer(State state) {
        this.state = state;
    }

    public void draw(Card card) {
        state.draw(card);
    }

    public void updatePossession(Money money) {
        possession =  possession.update(money);
    }

    public void updatePossessionWithRate(Money money, double rate) {
        possession =  possession.update(money.multiply(rate));
    }


    public double getPossession() {
        return possession.getMoney();
    }
}

package domain;

public interface State {
    State draw(Card card);
    State stay();
    boolean isFinished();
    Cards cards();
    double profit(double value);
}

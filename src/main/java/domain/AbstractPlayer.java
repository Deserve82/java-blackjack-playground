package domain;

import java.util.List;

public abstract class AbstractPlayer {
    private final Cards cards;
    private Money money;

    protected AbstractPlayer(List<Card> cardList, int money) {
        cards = new Cards(cardList);
        this.money = new Money(money);
    }

    protected AbstractPlayer(List<Card> cardList) {
        this(cardList, 0);
    }

    public List<Card> getCards() {
        return cards.getCardList();
    }

    public int getSumPoints() {
        return cards.getValueSum();
    }

    public void addCard(Card card) {
        cards.addCard(card);
    }

    public boolean isBust(){
        return cards.getValueSum() > 21;
    }

    public boolean isBlackJack(){
        return cards.getValueSum() == 21;
    }

    public synchronized void increasePossession(int money) {
        this.money = this.money.increase(money);
    }

    public synchronized void decreasePossession(int money) {
        this.money = this.money.decrease(money);
    }

    public int getPossession() {
        return money.getMoney();
    }

    public boolean isBigger(AbstractPlayer counterpart){
        return this.cards.getValueSum() > counterpart.cards.getValueSum();
    }

    public boolean isSame(AbstractPlayer counterpart) {
        return this.cards.getValueSum() == counterpart.cards.getValueSum();
    }

    public abstract String getName();
}

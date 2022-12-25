package domain;

import java.util.HashMap;
import java.util.List;

public class Dealer extends AbstractPlayer{

    private final HashMap<Player, Money> playersBettingMoney;

    public Dealer(List<Card> dealerCards, HashMap<Player, Money> playersBetting) {
        super(dealerCards);
        playersBettingMoney = playersBetting;
    }

    public void checkPlayers() {
        playersBettingMoney.forEach(this::giveOrTakeMoney);
    }

    private void giveOrTakeMoney(Player player, Money betting) {
        if (player.isDoubleBlackJack()) {
            changePossession(player, this, betting.multiplied(1.5).getMoney());
            return;
        }

        if (this.isBust()) {
            changePossession(player, this, betting.getMoney());
            return;
        }

        if (player.isBust()) {
            changePossession(this, player, betting.getMoney());
            return;
        }

        if (player.isSame(this)) {
            player.increasePossession(betting.getMoney());
            return;
        }

        if (player.isBigger(this)) {
            changePossession(player, this, betting.getMoney());
            return;
        }

        changePossession(this, player, betting.getMoney());
    }

    private void changePossession(AbstractPlayer winner, AbstractPlayer loser, int amount) {
        winner.increasePossession(amount);
        loser.decreasePossession(amount);
    }

    @Override
    public String getName() {
        return "딜러";
    }
}

package domain;

import java.util.HashMap;
import java.util.List;

public class Dealer extends AbstractPlayer{

    private HashMap<Player, Money> playersBettingMoney;

    public Dealer(List<Card> dealerCards, HashMap<Player, Money> playersBetting) {
        super(dealerCards);
        playersBettingMoney = playersBetting;
    }

    public void checkPlayers() {
        playersBettingMoney.forEach(this::giveOrTakeMoney);
    }

    private void giveOrTakeMoney(Player player, Money betting) {
        if (player.isDoubleBlackJack()) {
            player.increasePossession(betting.multiplied(1.5).getMoney());
        }
    }
}

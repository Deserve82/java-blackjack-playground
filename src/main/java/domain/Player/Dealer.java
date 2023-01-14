package domain.Player;

import domain.CompareResult;
import domain.State.Finished;
import domain.State.State;
import java.util.List;

public class Dealer extends AbstractPlayer{

    public Dealer(State state) {
        super(state);
    }

    public void compare(List<Player> players) {
        players.forEach(player -> {
           Finished state = (Finished) this.state;
           CompareResult result = state.compare((Finished) player.state);
           changePossession(result, player, state.earnRate());
        });
    }

    private void changePossession(CompareResult dealerResult, Player player, double earnRate) {
        Money value = player.getBetting();
        if (dealerResult.isWin()) {
            updateDealerAndPlayer(value, player, earnRate, -earnRate);
            return;
        }
        if (dealerResult.isDraw()) {
            updateDealerAndPlayer(value, player, 0, 1.0);
            return;
        }
        updateDealerAndPlayer(value, player, -earnRate, earnRate);
    }

    private void updateDealerAndPlayer(Money money, Player player, double dealerRate, double userRate) {
        this.updatePossessionWithRate(money, dealerRate);
        player.updatePossessionWithRate(money, userRate);
    }
}

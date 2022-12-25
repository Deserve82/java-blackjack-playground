import domain.Dealer;
import domain.Deck;
import domain.Money;
import domain.Player;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import ui.InputView;
import ui.OutputView;

public class Game {

    private static final Deck deck = new Deck();
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        outputView.printTypeNames();
        String[] names = inputView.getNames();

        List<Integer> betting = Arrays.stream(names).map(name -> {
            outputView.printTypeBetting(name);
            return inputView.getBetting();
        }).collect(Collectors.toList());

        List<Player> players = Arrays.stream(names).map(name ->
                new Player(Arrays.asList(deck.pop(), deck.pop()), name))
                .collect(Collectors.toList());

        HashMap<Player, Money> playersBetting = new HashMap<>();

        for (int i=0; i<players.size(); i++) {
            playersBetting.put(players.get(i), new Money(betting.get(i)));
        }

        Dealer dealer = new Dealer(Arrays.asList(deck.pop(), deck.pop()), playersBetting);

        outputView.printPlayerGetTwoCards(Arrays.asList(names));

        outputView.printPlayerStatus(dealer);
        players.forEach(outputView::printPlayerStatus);


        for (Player player : players) {
            checkHitOrStand(player);
        }

        if (dealer.getSumPoints() <= 16) {
            outputView.printDealerGetOneMoreCard();
            dealer.addCard(deck.pop());
        }

        dealer.checkPlayers();

        outputView.printPlayerStatusWithResult(dealer);
        players.forEach(outputView::printPlayerStatusWithResult);

        outputView.printFinalResult();
        outputView.printMoney(dealer);
        players.forEach(outputView::printMoney);
    }

    private static void checkHitOrStand(Player player) {
        outputView.printHitOrStand(player.getName());

        while(inputView.isHit()) {
            player.addCard(deck.pop());
            outputView.printPlayerStatus(player);
            outputView.printHitOrStand(player.getName());
        }
    }
}

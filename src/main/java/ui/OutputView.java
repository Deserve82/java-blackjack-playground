package ui;

import domain.AbstractPlayer;
import domain.Dealer;
import domain.Deck;
import domain.Player;
import java.util.List;

public class OutputView {

    private void print(String value) {
        System.out.println(value);
    }

    public void printTypeNames() {
        print("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public void printTypeBetting(String name) {
        print(name + "의 배팅 금액은?");
    }

    public void printPlayerGetTwoCards(List<String> nameList) {
        print("딜러와 " + String.join(", ", nameList) + "에게 2장의 카드를 나누었습니다.");
    }

    public void printPlayerStatus(AbstractPlayer player) {
        if (player instanceof Dealer) {
            print("딜러:" + player.getCards());
            return;
        }

        print(player.getName() + "카드: " + player.getCards());
    }

    public void printPlayerStatusWithResult(AbstractPlayer player) {
        if (player instanceof Dealer) {
            print("딜러:" + player.getCards() + "결과:" + player.getSumPoints());
            return;
        }

        print(player.getName() + "카드: " + player.getCards() + "결과:" + player.getSumPoints());
    }

    public void printDealerGetOneMoreCard() {
        print("딜러는 16이하라 한장의 카드를 더 받았습니다.");
    }

    public void printHitOrStand(String name) {
        print(name+"는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)");
    }

    public void printResult(List<AbstractPlayer> players) {
        print("## 최종 수익");
        players.forEach(this::printMoney);
    }

    private void printMoney(AbstractPlayer player) {
        print(player.getName() + ": " + player.getPossession());
    }
}

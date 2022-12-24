package ui;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String[] getNames() {
        return scanner.nextLine().split(",");
    }

    public int getBetting() {
        return scanner.nextInt();
    }

    public boolean isHit() {
        String response = scanner.nextLine();
        return response.equals("y");
    }
}

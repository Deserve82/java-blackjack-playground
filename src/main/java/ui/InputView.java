package ui;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String[] getNames() {
        return scanner.nextLine().split(",");
    }

    public int getBetting() {
        return Integer.parseInt(scanner.nextLine());
    }

    public boolean isHit() {
        String response = scanner.nextLine();
        return response.equals("y");
    }
}

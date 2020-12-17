package view;

import domain.Money;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Money inputMoney() {
        System.out.println("구입할 금액을 입력하세요.");
        int money = Integer.parseInt(getInput());
        try {
            return new Money(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return inputMoney();
        }
    }

    private static String getInput() {
        return scanner.nextLine().trim();
    }
}

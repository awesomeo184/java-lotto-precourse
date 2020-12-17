package controller;

import domain.Money;
import view.InputView;

public class LottoMachine {

    public static void run() {
        Money money = InputView.inputMoney();
        System.out.println(money);

    }

}

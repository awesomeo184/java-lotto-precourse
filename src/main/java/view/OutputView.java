package view;

import domain.Lotto;
import java.util.List;

public class OutputView {


    public static void printLottos(List<Lotto> lottos) {
        System.out.println("## 로또 번호");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

}

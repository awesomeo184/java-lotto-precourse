package controller;

import domain.Lotto;
import domain.LottoFactory;
import domain.LottoRepository;
import domain.Money;
import domain.WinningLotto;
import java.util.List;
import view.InputView;
import view.OutputView;

public class LottoMachine {

    private static final int AMOUNT_UNIT = 1000;

    public void run() {
        Money money = InputView.inputMoney();
        List<Lotto> lottos = buyLotto(money);
        OutputView.printLottos(lottos);

        WinningLotto winningLotto = InputView.inputWinningLotto();
    }

    private List<Lotto> buyLotto(Money money) {
        int ticketAmount = money.getAmount() / AMOUNT_UNIT;

        for (int i = 0; i < ticketAmount; i++) {
            LottoRepository.add(new Lotto(LottoFactory.createLottoNumbers()));
        }

        return LottoRepository.lottos();
    }

}

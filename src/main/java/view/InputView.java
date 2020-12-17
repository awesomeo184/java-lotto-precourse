package view;

import domain.Lotto;
import domain.LottoFactory;
import domain.Money;
import domain.WinningLotto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    public static Money inputMoney() {
        System.out.println("## 구입할 금액을 입력하세요.");
        int money = Integer.parseInt(getInput());
        try {
            return new Money(money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return inputMoney();
        }
    }

    public static WinningLotto inputWinningLotto() {
        List<Integer> winningLottoNumbers = inputWinningLottoNumbers();
        Lotto lotto = new Lotto(winningLottoNumbers);
        int bonusNumber = inputBonusNumber(winningLottoNumbers);

        return new WinningLotto(lotto, bonusNumber);
    }

    private static List<Integer> inputWinningLottoNumbers() {
        List<Integer> winningLottoNumbers = new ArrayList<>();

        System.out.println("## 지난주 당첨 번호를 입력하세요.");
        String numbers = getInput();

        try {
            String[] ListOfString = numbers.split(SEPARATOR);
            for (String number : ListOfString) {
                winningLottoNumbers.add(Integer.parseInt(number));
            }
            LottoFactory.validateNonDuplicateNumbers(winningLottoNumbers);
            LottoFactory.validateRange(winningLottoNumbers);
            return winningLottoNumbers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
            return inputWinningLottoNumbers();
        }
    }

    private static int inputBonusNumber(List<Integer> winningLottoNumbers) {
        System.out.println("## 보너스 번호를 입력하세요.");
        int bonusNumber = Integer.parseInt(getInput());
        try {
            if (winningLottoNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복될 수 없습니다.");
            }
            LottoFactory.validateRangeOfBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
            return inputBonusNumber(winningLottoNumbers);
        }
    }

    private static String getInput() {
        return scanner.nextLine().trim();
    }
}

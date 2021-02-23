package lotto.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);
    public static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요";
    public static final String INPUT_BONUS_BALL_NUMBER = "보너스 볼을 입력해주세요";
    public static final String INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_NUMBER = "수동으로 구매할 로또 수를 입력해 주세요.";

    public static int inputMoney() {
        OutputView.printInputMessage(INPUT_MONEY);
        return scanner.nextInt();
    }

    public static int inputManualLottoCount() {
        OutputView.printInputMessage(INPUT_MANUAL_LOTTO_NUMBER);
        return scanner.nextInt();
    }

    public static String inputManualLottoNumbers() {
        OutputView.printInputMessage(INPUT_MANUAL_LOTTO_NUMBERS);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static String inputWinningNumbers() {
        OutputView.printInputMessage(INPUT_WINNING_NUMBERS);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_BALL_NUMBER);
        return scanner.nextInt();
    }
}
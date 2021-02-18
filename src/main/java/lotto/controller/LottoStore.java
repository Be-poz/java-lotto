package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;

    public void process() {
        Lottos lottos = buyLotto();
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        Map<LottoRank, Integer> lottoResultStatistics = lottos.getStatistics(winningNumbers, bonusNumber);
        printLottoResult(lottoResultStatistics, lottos);
    }

    public Lottos buyLotto() {
        int possessedMoney = InputView.inputMoney();
        Lottos purchasedLottos = new Lottos(calculateAffordableLottoPieces(possessedMoney));
        OutputView.printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    public void printLottoResult(Map<LottoRank, Integer> lottoResultStatistics, Lottos lottos) {
        double profitRate = calculateProfitRate(lottoResultStatistics, lottos.getSize());
        OutputView.printLottoStatistics(lottoResultStatistics, profitRate);
    }

    public double calculateProfitRate(Map<LottoRank, Integer> exampleLottosResult, int lottoPiece) {
        double sum = 0;
        for (Entry<LottoRank, Integer> keyValue : exampleLottosResult.entrySet()) {
            sum += keyValue.getKey().getPrizeMoney() * keyValue.getValue();
        }
        double investCapital = lottoPiece * LOTTO_PRICE;
        double rawProfitRate = sum / investCapital;
        return Math.round(rawProfitRate * 100) / 100.00;
    }

    public int calculateAffordableLottoPieces(int money) {
        return money / LOTTO_PRICE;
    }

}

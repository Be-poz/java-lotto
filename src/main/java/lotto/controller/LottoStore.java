package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;
import java.util.Map.Entry;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;

    public void process() {
        Lottos purchasedLottos = buyLotto();
        WinningLotto winningLotto = decideWinningLotto();
        Map<LottoRank, Integer> lottoResultStatistics = purchasedLottos.getStatistics(winningLotto);
        printLottoResult(lottoResultStatistics, purchasedLottos);
    }

    public Lottos buyLotto() {
        Money money = new Money(InputView.inputMoney());
        Lottos purchasedLottos = new Lottos(calculateAffordableLottoTickets(money));
        OutputView.printPurchasedLottos(purchasedLottos);
        return purchasedLottos;
    }

    private WinningLotto decideWinningLotto() {
        Lotto winningLotto = new Lotto(InputView.inputWinningNumbers());
        BonusBall bonusBall = new BonusBall(InputView.inputBonusNumber(), winningLotto);
        return new WinningLotto(winningLotto, bonusBall);
    }

    public void printLottoResult(Map<LottoRank, Integer> lottoResultStatistics, Lottos lottos) {
        double profitRate = calculateProfitRate(lottoResultStatistics, lottos.getSize());
        OutputView.printLottoStatistics(lottoResultStatistics, profitRate);
    }

    public double calculateProfitRate(Map<LottoRank, Integer> lottoResultStatistics, int purchasedLottoCount) {
        double initialCapital = purchasedLottoCount * LOTTO_PRICE;
        double sum = 0;

        for (LottoRank rank : lottoResultStatistics.keySet()) {
            int rankMatchLottoCount = lottoResultStatistics.get(rank);
            sum += rank.getPrizeMoney() * rankMatchLottoCount;
        }
        double rawProfitRate = sum / initialCapital;

        return Math.round(rawProfitRate * 100) / 100.00;
    }

    public int calculateAffordableLottoTickets(Money money) {
        return money.getAffordableLottoTickets();
    }
}
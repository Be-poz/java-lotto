package lotto.controller;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {
    private static final Lotto lotto = Lotto.from("1,2,3,4,5,6");
    private static final BonusBall bonusBall = new BonusBall(7, lotto);
    private static final WinningLotto winningLotto = new WinningLotto(lotto, bonusBall);

    private static Stream<Arguments> provideLottosResult() {
        return Stream.of(
                Arguments.of(Lotto.from("2, 4, 8, 9, 13, 25"), 0.00),
                Arguments.of(Lotto.from("2, 4, 6, 8, 13, 25"), 5.00),
                Arguments.of(Lotto.from("2, 4, 6, 1, 7, 3"), 30000.00),
                Arguments.of(Lotto.from("1, 2, 3, 4, 5, 6"), 200000.00)
        );
    }

    @ParameterizedTest
    @DisplayName("총 수익률 계산")
    @MethodSource("provideLottosResult")
    void lottoProfitCalculateTest(Lotto exampleLotto, double profitRate) {
        Lottos exampleLottos = new Lottos(Collections.singletonList(exampleLotto));
        Map<LottoRank, Integer> exampleLottosResult =
                exampleLottos.getStatistics(winningLotto);
        double value = new LottoStore().calculateProfitRate(exampleLottosResult, 1);
        assertThat(value).isEqualTo(profitRate);
    }
}
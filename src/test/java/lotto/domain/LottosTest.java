package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private static final Lotto lotto = Lotto.from("1,2,3,4,5,6");
    private static final BonusBall bonusBall = new BonusBall(7, lotto);
    private static final WinningLotto winningLotto = new WinningLotto(lotto, bonusBall);

    private static Stream<Arguments> provideLottosResult() {
        return Stream.of(
                Arguments.of(Lotto.from("2,4,8,9,13,25"), LottoRank.NONE),
                Arguments.of(Lotto.from("2,4,7,9,13,25"), LottoRank.FIFTH),
                Arguments.of(Lotto.from("2,4,6,1,7,3"), LottoRank.SECOND),
                Arguments.of(Lotto.from("1,2,3,4,5,6"), LottoRank.FIRST)
        );
    }

    @Test
    @DisplayName("구입한 로또 매수만큼 로또 생성")
    void createLottos() {
        int expectedLottoSize = 14;
        Lottos lottos = new Lottos(expectedLottoSize);
        assertThat(lottos.getSize()).isEqualTo(expectedLottoSize);
    }

    @ParameterizedTest
    @DisplayName("당첨 통계 결과 수합")
    @MethodSource("provideLottosResult")
    void lottosResult(Lotto exampleLotto, LottoRank exampleRank) {
        Lottos exampleLottos = new Lottos(Collections.singletonList(exampleLotto));
        Map<LottoRank, Integer> exampleLottosResult =
                exampleLottos.getStatistics(winningLotto);
        int value = exampleLottosResult.get(exampleRank);
        assertThat(value).isEqualTo(1);
    }


}
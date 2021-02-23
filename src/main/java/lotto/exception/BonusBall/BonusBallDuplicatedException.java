package lotto.exception.BonusBall;

public class BonusBallDuplicatedException extends BonusBallException {
    private static final String ERROR_MESSAGE = "[ERROR] 보너스 볼은 당첨 번호와 중복되어서는 안됩니다.";

    public BonusBallDuplicatedException() {
        super(ERROR_MESSAGE);
    }
}
package lotto.exception;

public class BonusBallException extends RuntimeException{
    public static final String ERROR_MESSAGE = "보너스 볼은 당첨 번호와 중복되어서는 안됩니다.";

    public BonusBallException() {
        super(ERROR_MESSAGE);
    }
}

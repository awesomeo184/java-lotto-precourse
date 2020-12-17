package domain;

public class Money {

    private static final int AMOUNT_UNIT = 1000;
    private static final int MAX_AMOUNT = 100_000;
    private final int amount;

    public Money(int amount) {
        validateUnit(amount);
        validateMaxAmount(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    private void validateUnit(int amount) {
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("금액은 1,000의 배수여야 합니다.");
        }
    }

    private void validateMaxAmount(int amount) {
        if (amount > MAX_AMOUNT) {
            throw new IllegalArgumentException("금액은 100,000원 이하여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.amount) + "원";
    }
}

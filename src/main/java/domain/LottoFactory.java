package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoFactory {
    private static final Random RANDOM = new Random();
    private static final int NUMBERS_UNIT = 6;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;

    public LottoFactory() {
    }

    public static int nextInt(final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException();
        }

        if (startInclusive < 0) {
            throw new IllegalArgumentException();
        }

        if (startInclusive == endInclusive) {
            return startInclusive;
        }

        return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
    }

    public static List<Integer> createLottoNumbers() {
        List<Integer> numbers = createSixNumberList();
        try {
            validateNonDuplicateNumbers(numbers);
            validateRange(numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            return createLottoNumbers();
        }
    }


    public static List<Integer> createSixNumberList() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < NUMBERS_UNIT; i++) {
            numbers.add(nextInt(LOWER_BOUND, UPPER_BOUND));
        }
        return numbers;
    }

    public static void validateNonDuplicateNumbers(List<Integer> numbers) {
        Set set = new HashSet(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public static void validateRange(List<Integer> numbers) {
        boolean isValidRange = numbers.stream()
            .allMatch(number -> LOWER_BOUND <= number && number <= UPPER_BOUND);
        if (!isValidRange) {
            throw new IllegalArgumentException("로또 번호는 1에서 45 사이의 정수여야 합니다.");
        }
    }
}
package baseball;

public class Validator {
    public static void validateInput(String input) {
        if (input == null || input.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char digitChar : input.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            if (digit < 1 || digit > 9) {
                throw new IllegalArgumentException();
            }
        }
    }
}

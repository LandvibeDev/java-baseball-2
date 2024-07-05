package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class InputHandler {
    public static List<Integer> getUserInput() {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            String inputUserNum = camp.nextstep.edu.missionutils.Console.readLine();
            if (inputUserNum == null || inputUserNum.length() != 3) {
                throw new IllegalArgumentException();
            }

            List<Integer> userInput = new ArrayList<>();
            for (char digitChar : inputUserNum.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);
                if (digit < 1 || digit > 9) {
                    throw new IllegalArgumentException();
                }
                userInput.add(digit);
            }
            return userInput;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 다시 시도해주세요.");
        }
    }
}

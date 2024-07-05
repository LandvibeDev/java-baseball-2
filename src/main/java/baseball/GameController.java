package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameController {
    public static void startGame() {
        boolean again = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (again) {
            NumberGenerator numberGenerator = new NumberGenerator();
            List<Integer> computerNum = numberGenerator.getRandomComputerNumber();

            boolean baseballGame = true;
            while (baseballGame) {
                InputHandler inputHandler = new InputHandler();
                List<Integer> userNum = inputHandler.getUserInput();

                NumberChecker numberChecker = new NumberChecker();
                baseballGame = numberChecker.checkNumber(computerNum, userNum);
            }

            again = askForRestart();
        }
    }

    private static boolean askForRestart() {
        try {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int restart = Integer.parseInt(Console.readLine());
            if (restart == 1) {
                return true;
            } else if (restart == 2) {
                return false;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 입력입니다. 게임을 종료합니다.");
        }
    }
}

package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        boolean again = true;
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (again) {
            List<Integer> computerNum = getRandomComputerNumber();

            /*  랜덤 숫자 확인용
            for(int i=0; i<3; i++) {
                System.out.print(computerNum.get(i));
                System.out.println();
            }
            */

            boolean baseballGame = true;
            while (baseballGame) {
                List<Integer> userNum = getUserInput();
                baseballGame = checkNumber(computerNum, userNum);
            }
            try {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int restart = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
                if (restart == 1) {
                    again = true;
                }
                else if (restart == 2) {
                    again = false;
                }
                else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    // 컴퓨터 숫자 생성 함수
    private static List<Integer> getRandomComputerNumber() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }

    // 사용자 입력 함수
    private static List<Integer> getUserInput() {
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
            throw new IllegalArgumentException();
        }
    }

    // 숫자 비교 함수
    private static boolean checkNumber(List<Integer> computerNum, List<Integer> userNum) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (userNum.get(i).equals(computerNum.get(i))) {
                strike++;
            } else if (computerNum.contains(userNum.get(i))) {
                ball++;
            }
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false; // 게임 종료
        }  else {
            if (ball > 0) {
                System.out.print(ball + "볼 ");
            }
            if (strike > 0) {
                System.out.print(strike + "스트라이크");
            }
            System.out.println();
        }
        return true;
    }
}

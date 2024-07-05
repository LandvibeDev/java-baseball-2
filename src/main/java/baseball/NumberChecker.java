package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberChecker {
    public boolean checkNumber(List<Integer> computerNum, List<Integer> userNum) {
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
        } else {
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

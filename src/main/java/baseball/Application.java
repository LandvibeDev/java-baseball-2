package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void checkF(int checknum, String pinnum) {
        int strike = 0;
        int ball = 0;

        String check = Integer.toString(checknum);
        String pin = pinnum;

        for (int i = 0; i < 3; i++) {
            if (check.charAt(i) == pin.charAt(i)) {
                strike++;
            } else if (pin.indexOf(check.charAt(i)) != -1) {
                ball++;
            }
        }

        if (strike == 3) {
            System.out.println("3 스트라이크");
            System.out.println("3 개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strike > 0 || ball > 0) {
            System.out.println(strike + " 스트라이크 " + ball + " 볼");
        } else {
            System.out.println("낫싱");
        }
    }

    public static void main(String[] args) {
        boolean play = true;

        while (play) {
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int num : computer) {
                sb.append(num);
            }
            String computerNumbers = sb.toString();

            System.out.println("숫자 야구 게임을 시작합니다.");
            boolean test = false;

            while (!test) {
                try {
                    System.out.println("숫자를 입력해주세요 :");
                    int a = Integer.parseInt(Console.readLine());
                    if (a < 100 || a > 999) {
                        throw new IllegalArgumentException("세 자리 수를 입력해야 합니다.");
                    }

                    checkF(a, computerNumbers);

                    // 게임 종료 여부를 판단하여 재시작 또는 종료 선택
                    if (is(a, computerNumbers)) {
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        int sel = Integer.parseInt(Console.readLine());

                        if (sel == 1) {
                            break; // 내부 루프 종료하여 게임 재시작
                        } else if (sel == 2) {
                            play = false;
                            test = true;
                        } else {
                            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
                        }
                    }

                } catch ( IllegalArgumentException e) {
                    System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                }
            }
        }
    }

    public static boolean is(int checknum, String pinnum) {
        int strike = 0;

        String check = Integer.toString(checknum);
        String pin = pinnum;

        for (int i = 0; i < 3; i++) {
            if (check.charAt(i) == pin.charAt(i)) {
                strike++;
            }
        }

        return strike == 3;
    }
}

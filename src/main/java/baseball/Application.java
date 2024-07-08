package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.");
        int[] randoms = new int[3];
        RandomNumber random = new RandomNumber();
        random.randomNumber(randoms);

        while (true) {
            try {
                System.out.print("숫자를 입력해주세요 : ");

                String answer = Console.readLine();
                ExceptionHandler exceptionHandler = new ExceptionHandler();
                exceptionHandler.checkValid(answer);

                String[] answers = new String[3];
                for (int i = 0; i < 3; i++) {
                    answers[i] = answer.substring(i, i + 1);
                }

                Count count = new Count();
                count.countStrike(randoms, answers);
                count.countBall(randoms, answers);
                count.printCount();

                if (count.getStrikes() == 3) {
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int option = scanner.nextInt();
                    if (option == 2) {
                        return;
                    } else {
                        random.randomNumber(randoms);
                    }
                }
            } catch (IllegalArgumentException e){
                throw e;
            }
        }
    }
}

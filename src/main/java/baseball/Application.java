package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("숫자 야구 게임을 시작합니다.?");

        while (true) {

            Random random = new Random();
            int answerNum = 100 + random.nextInt(900);

            System.out.println("정답: " + answerNum);

            while (true) {

                int answerOne = answerNum / 100;
                int answerTwo = (answerNum % 100) / 10;
                int answerThree = answerNum % 10;

                System.out.print("숫자를 입력해주세요 : ");

                int inputNum;

                try {

                    inputNum = scan.nextInt();

                    if (inputNum < 100 || inputNum > 999) {
                        throw new IllegalArgumentException();
                    }

                } catch (IllegalArgumentException e) {
                    return;
                }

                int myOne = inputNum / 100;
                int myTwo = (inputNum % 100) / 10;
                int myThree = inputNum % 10;

                int ballCnt = 0;
                int strikeCnt = 0;

                if (myOne == answerOne) {
                    strikeCnt++;
                } else if (myOne == answerTwo || myOne == answerThree) {
                    ballCnt++;
                }

                if (myTwo == answerTwo) {
                    strikeCnt++;
                } else if (myTwo == answerOne || myTwo == answerThree) {
                    ballCnt++;
                }

                if (myThree == answerThree) {
                    strikeCnt++;
                } else if (myThree == answerOne || myThree == answerTwo) {
                    ballCnt++;
                }

                if (strikeCnt == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                    int choice;
                    try {
                        choice = scan.nextInt();

                        if (choice != 1 && choice != 2) {
                            throw new IllegalArgumentException();
                        }
                    } catch (IllegalArgumentException e) {
                        return;
                    }

                    if (choice == 1) {
                        break;
                    } else if (choice == 2) {
                        return;
                    }

                } else if (ballCnt == 0 && strikeCnt == 0) {
                    System.out.println("낫싱");
                } else if (ballCnt == 0) {
                    System.out.println(strikeCnt + "스트라이크");
                } else if (strikeCnt == 0) {
                    System.out.println(ballCnt + "볼");
                } else {
                    System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
                }

            }
        }
    }
}

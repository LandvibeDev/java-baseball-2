package baseball;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
public class Application {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        boolean option = true;
        while(option) {
            boolean sad = true;
            char[] ranArr = new char[3];
            do {
                int random = Randoms.pickNumberInRange(123, 987);
                String randomStr = Integer.toString(random); //문자열로 바꾸기
                //char 배열에 저장하기
                for (int i = 0; i < 3; i++) {
                    ranArr[i] = randomStr.charAt(i);
                }
                for (int i = 0; i < 3; i++) {
                    System.out.print(ranArr[i]);
                }
                if (ranArr[0] != ranArr[1] && ranArr[1] != ranArr[2] && ranArr[0] != ranArr[2]) {
                    if(ranArr[1]!=0&&ranArr[2]!=0){
                        sad=false;
                    }
                } else {
                    ranArr= new char[3];
                    continue;
                }
            }while(sad);

            //주석깃허브
            while (true) {
                System.out.print("숫자를 입력해주세요: ");
                String sscore = scanner.nextLine();
                try {
                    if (sscore.length() != 3) {
                        throw new IllegalArgumentException();
                    }

                    char[] score = new char[3];
                    for (int i = 0; i < 3; i++) {
                        score[i] = sscore.charAt(i); //숫자 하나하나 따로 나누기. 비교를 위해!
                    }
                    int ball = 0, strike = 0;

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (i == j && score[i] == ranArr[j]) {
                                strike++;
                            } else if (i != j && score[i] == ranArr[j]) {
                                ball++;
                            }

                        }
                    }
                    if (strike == 3) {
                        System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임종료");
                        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                        int input = scanner.nextInt();
                        scanner.nextLine();

                        if (input == 2) {
                            System.out.println("게임종료!");
                            option = false;
                            break;
                        } else if (input == 1) {
                            break;
                        }

                    } else if (strike > 0 && ball > 0) {
                        System.out.println(ball + "볼 " + strike + "스트라이크");
                    } else if (strike > 0) {
                        System.out.println(strike + "스트라이크");
                    } else if (ball > 0) {
                        System.out.println(ball + "볼");
                    } else if (ball == 0 && strike == 0) {
                        System.out.println("낫싱");
                    }
                }catch(IllegalArgumentException e){
                    System.out.println("잘못된 입력입니다: ");
                    return;
                }
            }

        }
    }
}
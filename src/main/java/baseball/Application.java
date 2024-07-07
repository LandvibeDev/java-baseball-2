package baseball;

import  camp.nextstep.edu.missionutils.Randoms;
import  camp.nextstep.edu.missionutils.Console;


import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        do {
            //랜덤 숫자 생성 1-9 서로 다른 숫자 세자리
            List<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber);
                }
            }


            //숫자 야구 게임을 시작합니다. 시작 멘트 출력 사용자 입력 받기
            System.out.println("숫자 야구 게임을 시작합니다.");//print은 줄바꿈안하고 println은 줄바꿈을 함
            do {
                System.out.println("숫자를 입력해주세요 : ");

                //사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
                String Input = Console.readLine();


                //3글자가 아니거나 중복 있으면 예외처리
                if (checkInput(Input)) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }

                //스트라이크 볼 낫싱 처리
                int strikes = 0;
                int ball = 0;
                for (int i = 0; i < Input.length(); i++) {
                    char ch = Input.charAt(i);
                    if (ch-'0' == numbers.get(i)) {
                        strikes++;
                    } else {
                        for (int j = 0; j < Input.length(); j++) {
                            if (ch-'0'== numbers.get(j)&&i!=j) {
                                ball++;
                                break;

                            }
                        }
                    }
                }

                printResult(strikes, ball);
                if (strikes == 3) {
                    System.out.println("3스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }

            } while (true);


        }while(startNewGame());
    }
    //중복 없는지 체크

    public static boolean checkInput(String input) {
        if (input.length() != 3) {
            return true;
        }


        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch < '1' || ch > '9') {
                return true;
            }
            for (int j = i + 1; j < input.length(); j++) {
                if (ch == input.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void printResult(int strikes,int ball){
        if(strikes==0&& ball==0){
            System.out.println("낫싱");
        }
        else if(strikes!=0&&ball!=0){
            System.out.println(strikes+"스트라이크 "+ball+"볼" );
        }
        else if(strikes==0){
            System.out.println(ball+"볼");        }
        else{
            System.out.println(strikes+"스트라이크");
        }
    }
    public static boolean startNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String str = Console.readLine();
        if (str.equals("1")) {
            return true;
        } else if (str.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}

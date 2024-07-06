package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void Game(){
        while(true){
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>(); //랜덤 숫자 리스트
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            while(true){
                System.out.println("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                int in = Integer.parseInt(input);
                if (in < 0 || in > 999) {
                    throw new IllegalArgumentException();
                }
                int[] num = new int[3]; //입력 숫자 리스트
                for(int i = 0; i < 3; i++){
                    num[i] = input.charAt(i) - '0';
                }

                String result = Go(computer,num);

                System.out.println(result);
                if(result.equals("3스트라이크")){
                    break;
                }
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String next = Console.readLine();
            if (next.equals("2")) {
                break;
            }
            else if(!next.equals("1")){
                continue;
            }
        }
    }
    public static String Go(List<Integer> computer, int[] input){
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(computer.get(i).equals(input[j])){
                    if(i == j){
                        strike++;
                    }
                    else{
                        ball++;
                    }
                }
            }
        }
        if(ball == 0 && strike == 0){
            return "낫싱";
        }
        else if(strike == 0){
            return ball + "볼";
        }
        else if(ball == 0){
            return strike + "스트라이크";
        }
        else{
            return ball + "볼 " + strike + "스트라이크";
        }

    }
    public static void main(String[] args) {
        Game();
    }
}

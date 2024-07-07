package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }
    public static void printResult(int strike, int ball, int nothing){
        if (nothing == 3) {
            System.out.println("낫싱");
        } else if (ball != 0 && strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼");
        }
    }
    public static boolean[] checkState(String computer, String user){
        boolean[] check =  new boolean[]{false, false, false};
        for (int i = 0; i < 3; i++) {
            if (computer.charAt(i) == user.charAt(i)) {
                check[i] = true;
            }
        }
        return check;
    }
    public static int checkStrike(String computer, String user){
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (computer.charAt(i) == user.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }
    public static int checkBall(String computer, String user, boolean[] check){
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (check[i]) {
                    break; //스트라이크 처리가 된 숫자이면 넘기기
                }
                if (computer.charAt(j) == user.charAt(i) && i != j) {
                    ball++;
                    continue;
                }
            }
        }
        return ball;
    }
    public static void startGame(){
        String computer, user;
        int strike, ball, nothing;
        boolean[] check = new boolean[3];
        do{
            computer = setComputer();
            strike=0; ball=0; nothing=0;
            while(true){
                user = setUser();
                if(check3Strike(computer, user)){ //정답을 맞힌 경우
                    break;
                }
                else{ //정답이 아닌 경우
                    check = checkState(computer, user);
                    strike = checkStrike(computer, user);
                    ball = checkBall(computer, user, check);
                    nothing = 3-(strike+ball);
                    printResult(strike, ball, nothing);
                }
            }

        }while(restartGame());
    }
    public static boolean restartGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String game = Console.readLine();
        if(game.equals("2")) return false;
        return true;
    }
    public static boolean check3Strike(String computer, String user){
        if (computer.equals(user)) {
            System.out.println("3 스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
    public static String setComputer(){
        String computer="";
        for(int i=0;i<3;i++) {
            int num = Randoms.pickNumberInRange(1, 9);
            computer += num;
        }
        return computer;
    }
    public static String setUser(){
        System.out.print("숫자를 입력해주세요 : ");
        String user = Console.readLine();
        if(user.length()!=3 || !(user.chars().allMatch(Character::isDigit))){ //사용자 입력 답변의 길이가 다르거나 숫자가 아니면
            throw new IllegalArgumentException();
        }
        return user;
    }
}

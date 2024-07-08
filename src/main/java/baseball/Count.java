package baseball;

public class Count {
    int strikes = 0;
    int balls = 0;

    int countStrike(int[] r, String[] str) {
        for (int i = 0; i < 3; i++) {
            if (r[i] == Integer.parseInt(str[i])) {
                strikes++;
            }
        }
        return strikes;
    }

    int countBall(int[] r, String[] str) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && r[i] == Integer.parseInt(str[j])) {
                    balls++;
                }
            }
        }
        return balls;
    }

    void printCount() {
        if(strikes == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }
        else if(strikes == 0 && balls != 0){
            System.out.println(balls + "볼");
        }
        else if(strikes != 0 && balls == 0){
            System.out.println(strikes + "스트라이크");
        }
        else if(strikes != 0 && balls != 0){
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }
        else{
            System.out.println("낫싱");
        }
    }

    int getStrikes() {
        return strikes;
    }
}

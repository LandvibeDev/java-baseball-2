package baseball;

import java.util.List;

public class Go {
    public String Check(List<Integer> computer, int[] input){
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
}

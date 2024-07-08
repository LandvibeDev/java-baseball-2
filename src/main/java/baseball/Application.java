package baseball;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        int[] computer;
        computer = new int[3];
        for(int i=0;i<3;i++){
            computer[i] = rand.nextInt(9)+1;
            for(int j=0;j<i;j++){
                if(computer[i] == computer[j]){
                    i--;
                }
            }
        }

        //System.out.println(computer[0]+" "+computer[1]+" "+computer[2] ) ;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            int num = scanner.nextInt(); //사용자 입력부분
            int[] user;
            user = new int[3];
            user[0] = num/100;
            user[1] = num/10%10;
            user[2] = num%10;

            int strike=0;
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(i == j && user[i] == computer[j]){
                        strike++;
                    }
                }
            }
            int ball=0; //다른자리에 있으면
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if( i!=j && user[i] == computer[j] ){
                        ball++;
                    }
                }
            }
            if(strike ==0 && ball >=1){
                System.out.println(ball +"볼");
            } else if( strike != 3 && (strike>=1 && ball ==0)){
                System.out.println(strike + "스트라이크");
            } else if(strike !=0 && strike !=3 &&(strike >=1 || ball>=1) ){
                System.out.println(ball +"볼 " + strike + "스트라이크");
            } else if(strike ==0 && ball==0){
                System.out.println("낫싱");
            }else if(strike == 3){
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int retry = scanner.nextInt();
                if(retry == 1){
                    continue;
                }else if(retry == 2){
                    break;
                }

            }
        }
    }
}

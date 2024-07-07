package baseball;

import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        {
            Scanner input = new Scanner(System.in);
            Random rand = new Random();
            int ranNum = rand.nextInt(900)+100;
            String sNum = String.valueOf(ranNum);
            String[] arrStr = sNum.split("");

            int strikeNum = 0;
            int ballNum = 0;
            System.out.println("숫자 야구 게임을 시작합니다.");
            while(true){
                int in;
                System.out.print("숫자를 입력해주세요 : ");
                in = input.nextInt();
                if(in >=1000 || in <= 100){
                    throw new IllegalArgumentException("세자리 수를 입력해야 합니다.\n프로그램을 종료합니다.");
                }
                int[] arr = new int[3];
                arr[0] = in/100;
                arr[1] = (in%100)/10;
                arr[2] = in%10;
                String[] arrStr2 = {arr[0]+"",arr[1]+"",arr[2]+""};

                for(int i = 0; i < 3; i++){
                    if(arrStr2[i].equals(arrStr[i])){
                        strikeNum++;
                    }
                }
                if(strikeNum == 2){
                    System.out.print("2스트라이크\n");
                    strikeNum=0;
                }else if(strikeNum == 1){
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                            if(arrStr2[j].equals(arrStr[i])){
                                ballNum++;
                            }
                        }
                    }
                    if(ballNum-strikeNum != 0)
                        System.out.print(ballNum-strikeNum + "볼 ");
                    System.out.print("1스트라이크\n");
                    ballNum=0;
                    strikeNum=0;
                }else if(strikeNum == 0){
                    for(int i = 0; i < 3; i++){
                        for(int j = 0; j < 3; j++){
                            if(arrStr2[j].equals(arrStr[i])){
                                ballNum++;
                            }
                        }
                    }
                    if(ballNum-strikeNum == 0)
                        System.out.print("낫싱\n");
                    else{
                        System.out.print(ballNum-strikeNum + "볼 \n");
                        strikeNum=0;
                        ballNum=0;
                    }
                }else if(strikeNum == 3) {
                    System.out.print("3스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
                    strikeNum=0;
                    ballNum=0;
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int re = input.nextInt();
                    if (re == 2)
                        break;
                    else{
                        ranNum = rand.nextInt(900)+100;
                        sNum = String.valueOf(ranNum);
                        arrStr = sNum.split("");
                        continue;
                    }
                }
            }
        }
    }
}

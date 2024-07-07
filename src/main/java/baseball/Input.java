package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private int[] in = new int[3];
    public String getUserInput(){
        return Console.readLine();
    }
    public int[] getInput(){
        String input = getUserInput();
        int a = Integer.parseInt(input);
        if(a < 0 || a > 999){
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < 3; i++){
            in[i] = input.charAt(i)-'0';
        }
        return in;
    }
}

package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> com;
    public void Random(){
        com = new ArrayList<>();
        while(com.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!com.contains(randomNumber)){
                com.add(randomNumber);
            }
        }
    }
    public List<Integer> getCom(){
        return com;
    }
}

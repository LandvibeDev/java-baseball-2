package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> ComputerNumbers;
    public void Random(){
        ComputerNumbers = new ArrayList<>();
        while(ComputerNumbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!ComputerNumbers.contains(randomNumber)){
                ComputerNumbers.add(randomNumber);
            }
        }
    }
    public List<Integer> getCom(){
        return ComputerNumbers;
    }
}

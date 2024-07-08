package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    void randomNumber(int[] r){
        boolean duplicate;

        for (int i = 0; i < 3; i++) {
            do {
                duplicate = false;
                r[i] = Randoms.pickNumberInRange(1, 9);
                for (int j = 0; j < i; j++) {
                    if (r[i] == r[j]) {
                        duplicate = true;
                        break;
                    }
                }
            } while (duplicate);
        }
    }
}

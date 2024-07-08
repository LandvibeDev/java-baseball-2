package baseball;

public class ExceptionHandler {
    void checkValid(String answer){
        if(answer.length() != 3){
            throw new IllegalArgumentException("3자리 수를 입력합니다.");
        }
        for (int i = 0; i < 3; i++) {
            String a = answer.substring(i, i + 1);
            if(a.equals("0")){
                throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            }
        }
    }
}

기능 구현 목록

1. public static void startGame()
야구 게임을 실행하는 함수.

do-while문을 통해 게임을 1번은 무조건 실행하며, 이후에는 restartGame의 결과에 따라 새로운 게임을 진행할지, 게임을 종료할지를 결정
do-while문 내부에서는 while문을 이용하여 사용자가 정답을 맞출때까지 게임을 진행함.

게임 처리 방식은 다음과 같음.

1) 사용자가 입력한 숫자가 형식에 맞으면 check3Strike를 통해 정답인지 확인.
2) 정답이라면 현재 게임을 종료하고 restartGame을 통해 게임을 다시 시작할지, 종료할지를 결정.
3) 정답이 아니라면 checkState를 이용하여 strike에 해당하는 숫자가 있다면 boolean 배열인 check에 해당 위치를 true로 변경하고 checkStrike를 이용하여 strike 개수를 구함.
4) checkBall을 이용하여 스트라이크에 해당하는 숫자의 위치를 제외한 나머지 숫자를 비교하여 ball을 구함.
5) nothing의 개수는 3-(stike+ball)로 계산
6) printResult를 이용하여 사용자가 입력한 숫자에 대한 결과를 출력
7) 맞출때까지 게임 진행

5. public static boolean restartGame()
사용자가 정답을 맞추면 게임 재시작 안내 문구를 출력하고 응답 결과를 boolean으로 반환하는 함수.

6. public staic String setComputer()
컴퓨터가 3자리의 숫자를 랜덤으로 생성하게 하는 함수.
1부터 9까지의 숫자를 Random으로 3번 생성해서 빈 문자열에 차례대로 더하는 방식.
3자리 숫자는 String 타입으로 나타냄.

7. public static String setUser()
'숫자를 입력해주세요'라는 메세지를 출력하고 사용자로부터 3자리 숫자를 입력받는 함수.
사용자가 입력한 문자의 길이가 3자리를 만족하지 않거나, 숫자 외의 값을 입력한 경우 IllegalArgumentException을 발생시킨다.

8. public static boolean check3Strike(String computer, String user)
computer의 숫자와 user가 입력한 숫자가 동일한지를 확인하는 함수.
정답을 맞춘 경우 '3스트라이크', '3개의 숫자를 모두 맞히셨습니다! 게임 종료'라는 메세지를 출력하고 true를 반환한다.
정답을 맞추지 못한 경우 false를 반환한다.

9. public static boolean[] checkState(String computer, String user)
사용자가 입력한 3자리 중 스트라이크에 해당하는 숫자의 위치를 true로 변경하는 함수.
ball을 계산할 때 strike처리가 된 숫자는 계산에 포함되지 않도록 하기 위한 기능.

10. public static int checkStrike(String computer, String user)
사용자가 입력한 3자리 중 스트라이크에 해당하는 숫자의 개수를 세고 반환하는 함수.

11. public static int checkBall(String computer, string user, boolean[] check)
사용자가 입력한 3자리 중 스트라이크에 포함되지 않은 숫자를 컴퓨터 숫자와 비교하며 ball의 개수를 세고 반환하는 함수.

12. public static void printResult(int strike, int ball, int nothing)
사용자가 입력한 3자리 숫자의 결과를 알려주는 함수.
nothing이 3개이면 '낫싱'을 출력함.
ball과 strike가 둘다 존재하면 볼, 스트라이크로 출력함.
ball만 존재하거나 strike만 존재하면 볼 또는 스트라이크만 출력함.

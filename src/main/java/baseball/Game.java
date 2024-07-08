package baseball;

public class Game {
    private Computer computer;
    private Input input;
    private Go go;
    public Game(){
        this.computer = new Computer();
        this.input = new Input();
        this.go = new Go();
    }
    public void newGame(){
        while(true){
            System.out.println("숫자를 입력해주세요 : ");
            int[] player = input.getInput();
            String result = go.Check(computer.getCom(), player);
            System.out.println(result);

            if(result.equals("3스트라이크")){
                break;
            }
        }
    }
    public void start(){
        while(true){
            System.out.println("숫자 야구 게임을 시작합니다.");
            computer.Random();

            newGame();

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String next = input.getUserInput();
            if (next.equals("2")) {
                break;
            }
            else if(!next.equals("1")){
                continue;
            }
        }
    }
}

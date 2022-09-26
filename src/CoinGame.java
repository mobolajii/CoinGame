import java.util.Scanner;

public class CoinGame {
    private int throwCoin;
    private int countGuess = 0;

    private String invalid = "Invalid input!";

    public String select(String answer){
        boolean compare = answer.equalsIgnoreCase("head")||answer.equalsIgnoreCase("tail");
        if(compare){
            return answer;
        }
        return invalid;
    }

    public int choice(String answer){
        if(answer.equals("head")){
            return 1;
        }
        return 0;
    }
    public void throwDice(){

        int i = 0;
        while (i<5){
            Scanner sc = new Scanner(System.in);
            throwCoin = (int) (Math.random() * 2);

            System.out.println("What is your guess?");
            String answer = sc.nextLine();
            String decision  =  select(answer);

            if(decision.equals(invalid)){
                System.out.println(invalid);
                break;
            }

            int returnchoice = choice(answer);
            boolean b = throwCoin == returnchoice;
            if(b){
                countGuess++;
                System.out.println("Correct choice!");
            }else{
                System.out.println("Wrong choice!");
            }
            if(countGuess==5){
                System.out.println("Congratulations, you have won a teddy bear!");
            }
            i++;
        }

    }

    public static void main(String[] args) {

        CoinGame coinGame = new CoinGame();
        coinGame.throwDice();


    }
}

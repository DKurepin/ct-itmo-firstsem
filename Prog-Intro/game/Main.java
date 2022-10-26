package game;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Player firstPLayer = null;
        Player secondPLayer = null;
        System.out.println("Choose first player: \"Random\" \"Human\"");
        String in = scan.next();
        if (in.equals("Human")) {
            firstPLayer = new HumanPlayer(new Scanner(System.in));
        } else if (in.equals("Random")) {
            firstPLayer = new RandomPlayer();
        }
        System.out.println("Choose second player: \"Random\" \"Human\"");
        in = scan.next();
        if (in.equals("Human")) {
            secondPLayer = new HumanPlayer(new Scanner(System.in));
        } else if (in.equals("Random")) {
            secondPLayer = new RandomPlayer();
        }
        TwoPlayerGame game = new TwoPlayerGame(
                new TicTacToeBoard(),
                firstPLayer,
                secondPLayer
        );
        System.out.println("Enter number of matches to win: ");
        int number = 0;
        try {
            number = scan.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Enter numbers not symbols: ");
            scan.nextLine();
        } catch (NoSuchElementException e){
            System.out.println("Bye Bye...");
        }
        int first = 0;
        int second = 0;
        int matches = 0;
        while (first < number || second < number) {
            boolean turn;
            if (matches % 2 != 0){
                turn = false;
            } else {
                turn = true;
            }
            int result = game.play(false, turn);
            game.clear();
            matches ++;
            switch (result) {
                case 1:
                    System.out.println("First player won");
                    first++;
                    break;
                case 2:
                    System.out.println("Second player won");
                    second++;
                    break;
                case 0:
                    System.out.println("Draw");
                    break;
                default:
                    throw new AssertionError("Unknown result " + result);
            }
            if(first == number){
                System.out.println("The Series was won by the first player ");
                break;
            } else if(second == number){
                System.out.println("The series was won by the second player ");
                break;
            }
        }
    }
}

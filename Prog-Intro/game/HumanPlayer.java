package game;

import java.awt.image.ImagingOpException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner in;

    public HumanPlayer(Scanner in) {
        this.in = in;
    }

    @Override
    public Move makeMove(Position position) {
        System.out.println();
        System.out.println("Current position");
        System.out.println(position);
        System.out.println("Enter you move for " + position.getTurn());
        Scanner in = new Scanner(System.in);
        Move move;
        while (true) {
            move = new Move(in.nextInt() - 1, in.nextInt() - 1, position.getTurn());
            try {
                if (position.isValid(move)) {
                    break;
                } else {
                    System.out.println("Invalid move");
                    System.out.println("Enter your move again: ");
                }
            } catch (InputMismatchException e){
                System.out.println("Enter numbers not symbols: ");
                in.nextLine();
            } catch (NoSuchElementException e){
                System.out.println("Bye Bye...");
                break;
            }
        }
        return move;
    }
}

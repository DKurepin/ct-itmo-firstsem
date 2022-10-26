import java.util.Scanner;

public class Kol {
   public static void main(String[] args) {



Scanner sc = new Scanner(System.in);
String number;
do {
    System.out.println("Please enter a positive number!");
    while (!sc.hasNextLine()) {
        System.out.println("That not a number!");
        sc.next(); // this is important!
    }
    number = sc.nextLine();
} while (number != "1");
System.out.println("Thank you! Got " + number);
}
}
import java.util.Scanner;

public class prog8A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double a = s.nextInt();
        double b = s.nextInt();
        double n = s.nextInt();
        int out = (int) (2 * (Math.ceil((n - b)/ (b - a))) + 1);
        System.out.println(out);
        s.close();
    }
}

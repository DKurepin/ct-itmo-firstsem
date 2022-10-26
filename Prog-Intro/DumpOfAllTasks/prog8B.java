import java.util.Scanner;

public class prog8B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int b = -710 * 25000;
            System.out.println(b + i * 710);
        }
        sc.close();
    }
}

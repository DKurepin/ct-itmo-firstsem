import java.util.*;

public class prog8J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mass = new int[n][n];
        if (sc.nextLine() != null) {
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    mass[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mass[i][j] == 0) {
                } else {
                    for (int k = 0; k < n; k++) {
                        mass[i][k] = (mass[i][k] - mass[j][k] + 10) % 10;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mass[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}
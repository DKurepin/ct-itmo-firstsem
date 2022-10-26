import java.util.Scanner;

public class ReverseOdd2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = (int) Math.pow(10, 6);
        int[] arr = new int[a];
        int b = (int) Math.pow(10, 6);
        int[] pos = new int[b];
        int kol = 0;
        int str = 0;
        while (scan.hasNextLine()) {
            String str1 = scan.nextLine();
            Scanner scannera = new Scanner(str1);
            int num = 0;
            while (scannera.hasNextInt()) {
                int digs = scannera.nextInt();
                if ((num + str) % 2 != 0) {
                    arr[kol] = digs;
                    pos[str]++;
                    kol++;
                }
                num++;
            }
            scannera.close();
            str++;
        }
        for (int i = str - 1; i >= 0; i--) {
            for (int j = 0; j < pos[i]; j++) {
                System.out.print(arr[kol - 1] + " ");
                kol--;
            }
            if (i != 0) {
                System.out.print("\n ");
            }
        }
    }
}
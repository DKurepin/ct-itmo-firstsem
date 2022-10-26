import java.util.Scanner;


public class labDM_A {

    public static int reflex(int[][] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((i == j) && (arr[i][j] == arr[j][i])) {
                    if (arr[i][j] == 0) {
                        counter += 0;
                    } else {
                        counter += 1;
                    }
                }
            }
        }
        if (counter == arr.length) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int antiReflex(int[][] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((i == j) && (arr[i][j] == arr[j][i])) {
                    if (arr[i][j] == 0) {
                        counter += 0;
                    } else {
                        counter += 1;
                    }
                }
            }
        }
        if (counter == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int sym(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static int antiSym(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i][j] == 1) {
                    if (arr[j][i] == 1) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public static int trans(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j) {
                    for (int h = 0; h < arr.length; h++) {
                        if ((arr[i][j] == 1) && (arr[j][h] == 1) && (i != h && j != h) && arr[i][h] == 0) {
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }

    public static int[][] comp(int[][] array1, int[][] array2) {
        int[][] arrarr = new int[array1.length][array1.length];
        int dig;
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                dig = 0;
                for (int k = 0; k < array1.length; k++) {
                    dig += array1[i][k] * array2[k][j];
                }
                if (dig > 0) {
                    dig = 1;
                }
                arrarr[i][j] = dig;
            }
        }
        return arrarr;
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array1 = new int[n][n];
        int[][] array2 = new int[n][n];
        int[][] compos = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array1[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array2[i][j] = scanner.nextInt();
            }
        }

        StringBuilder bio1 = new StringBuilder();
        StringBuilder bio2 = new StringBuilder();
        bio1.append(reflex(array1));
        bio1.append(antiReflex(array1));
        bio1.append(sym(array1));
        bio1.append(antiSym(array1));
        bio1.append(trans(array1));

        bio2.append(reflex(array2));
        bio2.append(antiReflex(array2));
        bio2.append(sym(array2));
        bio2.append(antiSym(array2));
        bio2.append(trans(array2));

        for (int i = 0; i < bio1.length(); i++) {
            System.out.print(bio1.charAt(i) + " ");
        }

        System.out.println();
        for (int i = 0; i < bio2.length(); i++) {
            System.out.print(bio2.charAt(i) + " ");
        }

        System.out.println();
        compos = comp(array1, array2);
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array1.length; j++) {
                System.out.print(compos[i][j] + " ");
            }
            System.out.println();
        }
    }
}

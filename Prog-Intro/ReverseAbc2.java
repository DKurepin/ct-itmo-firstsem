import java.io.IOException;

public class ReverseAbc2 {
    private static int[] numsOfArr;
    private static int[] linesOfArr;
    private static int idOfNums;
    private static int linesCounter;
    private static StringBuilder dig;

    public static void main(String[] args) {
        try {
            myScan sc1 = new myScan(System.in);
            int[] numsOfArr = new int[10];
            int[] linesOfArr = new int[10];
            int idOfNums = 0;
            int linesCounter = 0;
            while (sc1.hasNextLine()) {
                if (idOfNums >= numsOfArr.length) {
                    numsOfArr = extendArr(numsOfArr);
                }
                if (linesCounter >= linesOfArr.length) {
                    linesOfArr = extendArr(linesOfArr);
                }
                try {
                    String str = sc1.nextLine();
                    myScan sc2 = new myScan(str);
                    while (true) {
                        if (!sc2.hasNext()) {
                            break;
                        } else {
                            if (idOfNums >= numsOfArr.length) {
                                numsOfArr = extendArr(numsOfArr);
                            }
                            String posAbc = sc2.next();
                            idOfNums = getPosArrNums(numsOfArr, linesOfArr, idOfNums, linesCounter, posAbc);
                        }
                    }
                    sc2.close();
                    linesCounter += 1;
                } catch (IOException e) {
                    System.out.print("Something bad happened" + e.getMessage());
                }
            }
            int i = linesCounter - 1;
            while (i >= 0) {
                int j = 0;
                while (true) {
                    if (j >= linesOfArr[i]) {
                        break;
                    }
                    System.out.print(numsOfArr[idOfNums - 1] + " ");
                    idOfNums -= 1;
                    j += 1;
                }
                if (i != 0) {
                    System.out.print("\n ");
                }
                i -= 1;
            }
        } catch (IOException e) {
            System.out.print("Something bad happened" + e.getMessage());
        }
    }

    public static int[] extendArr(int[] arr) {
        int[] temp = new int[arr.length * 4];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        return temp;
    }

    private static int getPosArrNums(int[] numsOfArr, int[] linesOfArr, int idOfNums, int linesCounter, String posAbc) {
        int result;
        if (posAbc.length() != 0) {
            StringBuilder dig = new StringBuilder();
            int i = 0;
            while (i < posAbc.length()) {
                int utf = (int) posAbc.charAt(i) - 'a';
                if (posAbc.charAt(i) != '-') {
                    if (posAbc.charAt(i) != '+') {
                        dig.append(utf);
                    } else {
                        dig.append(posAbc.charAt(i));
                    }
                } else {
                    dig.append(posAbc.charAt(i));
                }
                i += 1;
            }
            idOfNums = getPosArrNums(numsOfArr, linesOfArr, idOfNums, linesCounter, dig);
        }
        result = idOfNums;
        return result;
    }

    private static int getPosArrNums(int[] numsOfArr, int[] linesOfArr, int idOfNums, int linesCounter, StringBuilder dig) {
        ReverseAbc2.numsOfArr = numsOfArr;
        ReverseAbc2.linesOfArr = linesOfArr;
        ReverseAbc2.idOfNums = idOfNums;
        ReverseAbc2.linesCounter = linesCounter;
        ReverseAbc2.dig = dig;
        String posAbc;
        posAbc = dig.toString();
        numsOfArr[idOfNums] = Integer.parseInt(posAbc);
        linesOfArr[linesCounter] += 1;
        idOfNums += 1;
        return idOfNums;
    }
}
import java.io.IOException;

public class Reverse {
    private static int[] numsOfArr;
    private static int[] linesOfArr;
    private static int idOfNums;
    private static int linesCounter;
    private static StringBuilder number;

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
                            String pos = sc2.next();
                            idOfNums = getPosArrNums(numsOfArr, linesOfArr, idOfNums, linesCounter, pos);
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
                while (j < linesOfArr[i]) {
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

    private static int getPosArrNums(int[] numsOfArr, int[] linesOfArr, int idOfNums, int linesCounter, String pos) {
        int result;
        if (pos.length() != 0) {
            StringBuilder number = new StringBuilder();
            int i = 0;
            while (i < pos.length()) {
                number.append(pos.charAt(i));
                i += 1;
            }
            idOfNums = getPosArrNums(numsOfArr, linesOfArr, idOfNums, linesCounter, number);
        }
        result = idOfNums;
        return result;
    }

    private static int getPosArrNums(int[] numsOfArr, int[] linesOfArr, int idOfNums, int linesCounter, StringBuilder number) {
        Reverse.numsOfArr = numsOfArr;
        Reverse.linesOfArr = linesOfArr;
        Reverse.idOfNums = idOfNums;
        Reverse.linesCounter = linesCounter;
        Reverse.number = number;
        String pos;
        pos = number.toString();
        numsOfArr[idOfNums] = Integer.parseInt(pos);
        linesOfArr[linesCounter] += 1;
        idOfNums += 1;
        return idOfNums;
    }
}


import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class WordStatInput {
    static int[] intCopy(int[] inputInt) {
        int newLength = inputInt.length * 2;
        int[] outputInt = new int[newLength];
        System.arraycopy(inputInt, 0, outputInt, 0, inputInt.length);
        return outputInt;
    }

    static String[] stringCopy(String[] inputStr) {
        int newLength = inputStr.length * 2;
        String[] outputStr = new String[newLength];
        System.arraycopy(inputStr, 0, outputStr, 0, inputStr.length);
        return outputStr;
    }

    public static void main(String[] args) {
        String[] words = new String[1];
        int[] counts = new int[1];
        int counter = 0;
        try {
            FileReader fileReader = new FileReader(args[0], StandardCharsets.UTF_8);
            BufferedReader buffered = new BufferedReader(fileReader);
            String line = buffered.readLine();


            while (line != null) {
                line += " ";
                int pos = 0;
                for (int j = 0; j < line.length(); j++) {
                    char symbol = line.charAt(j);
                    boolean is_dash = Character.getType(symbol) == Character.DASH_PUNCTUATION;
                    if (!(Character.isLetter(symbol) || is_dash || symbol == '\'')) {
                        String sub = line.substring(pos, j).toLowerCase();
                        if (!sub.isEmpty()) {
                            boolean check = false;
                            for (int i = 0; i < words.length; i++) {
                                if (sub.equals(words[i])) {
                                    counts[i] += 1;
                                    check = true;
                                    break;
                                }
                            }
                            if (!check) {
                                if (counter == words.length) {
                                    counts = intCopy(counts);
                                    words = stringCopy(words);
                                }
                                words[counter] = sub;
                                counts[counter] = 1;
                                counter++;
                            }
                        }
                        pos = j + 1;
                    }
                }
                line = buffered.readLine();
            }
            buffered.close();
        } catch (FileNotFoundException e) {
            System.out.print("Cannot find file for reader: ");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.out.println("File have unsupported encoding: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("find error: ");
            e.printStackTrace();
        }

        try {
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(args[1], StandardCharsets.UTF_8));
            for (int a = 0; a < counter; a++) {
                bufWriter.write(words[a] + " " + counts[a] + "\n");
            }
            bufWriter.close();

        } catch (FileNotFoundException e) {
            System.out.print("Cannot find file for reader: ");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            System.out.println("File have unsupported encoding: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("find error: ");
            e.printStackTrace();
        }
    }
}



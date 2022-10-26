import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;

public class WsppPosition {
    protected static BufferedWriter writer;
    protected static Map.Entry<String, List<String>> res;
    protected static StringBuilder str;
    protected static Map<String, List<String>> arrMap;
    protected static int counterOfLines;
    protected static int counter;

    public static void main(String[] args) {
        Map<String, List<String>> arrMap = new LinkedHashMap<>();
        int counterOfLines = 0;
        try {
            myScan sc1 = new myScan(new File(args[0]));
            int counter = 0;
            while (true) {
                if (sc1.hasNext()) {
                    String str = sc1.nextWord().toLowerCase();
                    if (counterOfLines >= sc1.linesQuantity()) {
                    } else {
                        counterOfLines = sc1.linesQuantity();
                        counter = 0;
                    }
                    if (!str.equals("")) {
                        counter++;
                        arrMap(arrMap, counterOfLines, counter, str);
                    }
                } else {
                    break;
                }
            }
            sc1.close();

        } catch (FileNotFoundException e) {
            System.out.print("File not found: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.print("Unsupported encoding: " + e.getMessage());
        } catch (IOException e) {
            System.out.print("IOException: " + e.getMessage());
        }
        try {
            try (BufferedWriter writer = new BufferedWriter
                    (new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {
                for (Map.Entry<String, List<String>> res : arrMap.entrySet()) {
                    StringBuilder str = new StringBuilder();
                    int i = 0;
                    while (i < res.getValue().size()) {
                        str.append(" ").append(res.getValue().get(i));
                        i += 1;
                    }
                    writeFunc(writer, res, str);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.print("File not found: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.print("Unsupported encoding: " + e.getMessage());
        } catch (IOException e) {
            System.out.print("IOException: " + e.getMessage());
        }
    }

    private static void arrMap(Map<String, List<String>> arrMap, int counterOfLines, int counter, String str) {
        WsppPosition.arrMap = arrMap;
        WsppPosition.counterOfLines = counterOfLines;
        WsppPosition.counter = counter;
        WsppPosition.str = new StringBuilder(str);
        if (!arrMap.containsKey(str)) {
            ArrayList<String> word = new ArrayList<>();
            word.add(counterOfLines + ":" + counter);
            arrMap.put(str, word);
        } else {
            arrMap.get(str).add(counterOfLines + ":" + counter);
        }
    }

    private static void writeFunc(BufferedWriter writer, Map.Entry<String, List<String>> res, StringBuilder str) {
        WsppPosition.writer = writer;
        WsppPosition.res = res;
        WsppPosition.str = str;
        try {
            writer.write(new StringBuilder().append(res.getKey()).append(" ").
                    append(res.getValue().size()).append(str.toString()).toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.print("IOException: " + e.getMessage());
        }
    }
}
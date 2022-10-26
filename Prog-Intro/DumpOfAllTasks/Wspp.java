import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import static java.nio.charset.StandardCharsets.*;

public class Wspp {
    protected static StringBuilder str;
    protected static Map<String, List<String>> arrMap;
    protected static int counter;
    protected static BufferedWriter writer;
    protected static Map.Entry<String, List<String>> res;

    public static void main(String[] args) {
        Map<String, List<String>> arrMap = new LinkedHashMap<>();
        try {
            myScan sc1 = new myScan(new File(args[0]));
            int counter = 0;
            while (true) {
                if (sc1.hasNext()) {
                    String str = sc1.nextWord().toLowerCase();
                    if (str.equals("")) {
                        continue;
                    }
                    counter++;
                    arrMap(arrMap, counter, str);
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
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), UTF_8));
            try {
                for (Entry<String, List<String>> res : arrMap.entrySet()) {
                    StringBuilder str = new StringBuilder();
                    int pos = 0;
                    while (pos < res.getValue().size()) {
                        str.append(" ").append(res.getValue().get(pos));
                        pos += 1;
                    }
                    writeFunc(writer, res, str);
                }
            } finally {
                writer.close();
            }
        } catch (FileNotFoundException e) {
            System.out.print("File not found: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.print("Unsupported encoding: " + e.getMessage());
        } catch (IOException e) {
            System.out.print("IOException: " + e.getMessage());
        }
    }

    private static void arrMap(Map<String, List<String>> arrMap, int counter, String str) {
        Wspp.arrMap = arrMap;
        Wspp.counter = counter;
        Wspp.str = new StringBuilder(str);
        if (!arrMap.containsKey(str)) {
            ArrayList<String> word = new ArrayList<>();
            word.add(String.valueOf(counter));
            arrMap.put(str, word);
        } else {
            arrMap.get(str).add(String.valueOf(counter));
        }
    }

    private static void writeFunc(BufferedWriter writer, Map.Entry<String, List<String>> res, StringBuilder str) {
        Wspp.writer = writer;
        Wspp.res = res;
        Wspp.str = str;
        try {
            writer.write(new StringBuilder().append(res.getKey()).append(" ").
                    append(res.getValue().size()).append(str.toString()).toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.print("IOException: " + e.getMessage());
        }
    }
}
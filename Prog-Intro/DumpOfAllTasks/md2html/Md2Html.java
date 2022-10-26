package md2html;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Md2Html {
    public static void main(String[] args) {
        try {
            BufferedWriter writer;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(args[0]), StandardCharsets.UTF_8))) {
                writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream(args[1]), StandardCharsets.UTF_8));
                String line = reader.readLine();
                while (true) {
                    if (line == null) break;
                    StringBuilder str = new StringBuilder();
                    while (true) {
                        if (!line.isEmpty()) break;
                        line = reader.readLine();
                    }
                    while (!(line == null || line.isEmpty())) {
                        if (str.length() != 0) {
                            str.append(System.lineSeparator());
                            str.append(line);
                            line = reader.readLine();
                        } else {
                            str.append(line);
                            line = reader.readLine();
                        }
                    }
                    if (str.length() > 0) {
                        Md2HtmlParser res = new Md2HtmlParser(str.toString());
                        writer.write(Md2HtmlParser.res.toString());
                        writer.newLine();
                    }
                }
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.print("File not found: " + e.getMessage());
        } catch (UnsupportedEncodingException e) {
            System.out.println("Problems with encoding: " + e.getMessage());
        } catch (IOException e) {
            System.out.print("IOException" + e.getMessage());
        }
    }
}
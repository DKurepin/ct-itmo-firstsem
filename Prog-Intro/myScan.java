import java.io.*;
import static java.nio.charset.StandardCharsets.*;

public class myScan {
    private final char[] storage = new char[80];
    private final Reader reading;
    private int chars = 0;
    private int storageLen = 0;
    private String nextInt = "";
    private String buffer = "";
    private String nextLine = "";
    private int linesQuantity = 1;
    private StringBuilder str;
    private StringBuilder string;


    public myScan(InputStream stream) throws IOException {
        this.reading = new InputStreamReader(stream, UTF_8);
        IncreaseStorage();
    }

    public myScan(File name) throws IOException {
        this.reading = new InputStreamReader(new FileInputStream(name), UTF_8);
        IncreaseStorage();
    }

    public myScan(String str) throws IOException {
        this.reading = new InputStreamReader(new ByteArrayInputStream(str.getBytes(UTF_8)),
                UTF_8);
        IncreaseStorage();
    }


    private boolean IncreaseStorage() throws IOException {
        boolean result;
        if (reading.ready()) {
            this.storageLen = reading.read(this.storage);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public String next() throws IOException {
        StringBuilder str = new StringBuilder();
        boolean isSymbol = false;
        while (true) {
            if (!hasNext()) {
                break;
            }
            char symbol =  nextChar();
            if (!Character.isWhitespace(symbol)) {
                str.append(symbol);
                isSymbol = true;
            } else {
                if (!isSymbol) {
                    continue;
                }
                break;
            }
        }
        return getString(str);
    }

    private String getString(StringBuilder str) {
        this.str = str;
        final String s;
        if (str.length() != 0) {
            s = str.toString();
        } else {
            s = "";
        }
        return s;
    }

    public int linesQuantity() throws IOException {
        return linesQuantity;
    }

    public boolean hasNext() throws IOException {
        if (this.chars < this.storageLen) {
            return true;
        }
        return reading.ready();
    }

    public char nextChar() throws IOException {
        int result = 0;
        int dub = this.chars;
        if (dub == 80) {
            dub = 0;
            this.chars = dub;
            if (!IncreaseStorage()) {
                result = -1;
            }
            if (result == 0) {
                result = getResult();
            }
            return (char) result;
        } else {
            result = getResult();
            return (char) result;
        }
    }

    private int getResult() {
        int result;
        int fin = this.chars++;
        result = this.storage[fin];
        return result;
    }


    public String nextWord() throws IOException {
        boolean isSymbol = false;
        StringBuilder string = new StringBuilder();
        while (true) {
            if (!hasNext()) {
                break;
            }
            char symbol =  nextChar();
            if (!Character.isWhitespace(symbol) && (Character.isLetter(symbol) ||
                    Character.DASH_PUNCTUATION == Character.getType(symbol) || symbol == '\'')) {
                        string.append(symbol);
                        isSymbol = true;
            } else {
                if (isSymbol) {
                    this.chars--;
                    break;
                }
            }
            if (symbol == '\n') {
                linesQuantity++;
            }
        }
        return getStr(string);
    }

    private String getStr(StringBuilder string) {
        this.string = string;
        String result;
        if (string.length() <= 0) {
            result = "";
        } else {
            result = string.toString();
        }
        return result;
    }

    public int nextInt() throws IOException {
        int result = 0;
        while (hasNextInt()) {
            buffer = nextInt;
            nextInt = "";
            result = Integer.parseInt(buffer);
        }
        if (!hasNextInt()) {
            throw new IOException("Nothing to read");
        }
        return result;
    }

    public boolean hasNextInt() throws IOException, NumberFormatException {
        boolean result = true;
        StringBuilder string;
        if (nextInt.length() == 0) {
            string = new StringBuilder();
            boolean isSymbol = false;
            while (true) {
                if (!hasNext()) {
                    break;
                }
                char symbol = nextChar();
                while (!Character.isWhitespace(symbol)) {
                    string.append(symbol);
                    isSymbol = true;
                }
                if (!isSymbol) {
                    continue;
                } else {
                    break;
                }
            }
            nextInt = string.toString();
        }
        return result;
    }

    public String nextLine() throws IOException {
        String result;
        if (hasNextLine()) {
            buffer = nextLine;
            nextLine = "";
            result = buffer;
        } else {
            throw new IOException("Nothing to read");
        }
        return result;
    }


    public boolean hasNextLine() throws IOException {
        boolean result;
        while (nextLine.length() != 0) {
            return true;
        }
        StringBuilder curLine = new StringBuilder();
        char symbol = ' ';
        boolean isLineHaveSymbols = false;
        while (true) {
            if ((symbol == '\n') || !hasNext()) {
                break;
            } else {
                symbol = nextChar();
                curLine.append(symbol);
                if (!Character.isWhitespace(symbol)) {
                    isLineHaveSymbols = true;
                }
                if (isLineHaveSymbols) {
                    continue;
                }
                curLine.append(symbol);
            }
        }
        nextLine = curLine.toString();
        if (nextLine.length() != 0) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public void close() throws IOException {
        reading.close();
    }
}
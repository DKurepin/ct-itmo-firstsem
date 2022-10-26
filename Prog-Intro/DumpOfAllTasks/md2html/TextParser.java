//package md2html;

import java.util.HashMap;
import java.util.Map;

public class TextParser {

    private StringBuilder source;
    private static Map<String, Integer> markdownIndex;
    private static String[] html;
    private static String[] markdownTag;
    private static int tagCount;

    static {
        html = new String[]{"em", "strong", "em", "strong", "s", "code", "var"};
        markdownTag = new String[]{"*", "**", "_", "__", "--", "`", "%"};
        tagCount = markdownTag.length;
        markdownIndex = new HashMap<>();
        for (int i = 0; i < markdownTag.length; i++) {
            markdownIndex.put(markdownTag[i], i);
        }
    }

    TextParser(StringBuilder source) {
        this.source = source;
    }


    private Integer getTagPosition(String cur) {
        Integer res = markdownIndex.get(cur);
        if (res == null) {
            res = markdownIndex.get(Character.toString(cur.charAt(0)));
        }
        if (res == null) {
            res = -1;
        }
        return res;
    }


    private StringBuilder SpecialHtmlSymbolsParser (StringBuilder source) {
        StringBuilder withoutTegs = new StringBuilder("");
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c == '<') {
                withoutTegs.append("&lt;");
            } else  if (c == '>') {
                withoutTegs.append("&gt;");
            } else if (c == '&') {
                withoutTegs.append("&amp;");
            } else if (c != '\\') {
                withoutTegs.append(c);
            }
        }
        return withoutTegs;
    }


    protected void toHtml(StringBuilder result) {
        String cur;
        int start = -1, end = -1, len;

        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == '\\') {
                i += 2;
                continue;
            }

            cur = source.substring(i, Math.min(i + 2, source.length()));
            start = getTagPosition(cur);

            if (start != -1) {
                len = markdownTag[start].length();

                for (int j = i + 2; j < source.length(); j++) {
                    if (source.charAt(j) == '\\') {
                        j += 2;
                        continue;
                    }

                    cur = source.substring(j, Math.min(j + 2, source.length()));
                    end = getTagPosition(cur);

                    if (end == start) {
                        new TextParser(new StringBuilder(source.substring(0, i))).toHtml(result);
                        result.append("<").append(html[start]).append(">");
                        new TextParser(new StringBuilder(source.substring(i + markdownTag[start].length(), j))).toHtml(result);
                        result.append("</").append(html[start]).append(">");
                        new TextParser(new StringBuilder(source.substring(j + len, source.length()))).toHtml(result);
                        return;
                    }
                }
            }
        }
        result.append(SpecialHtmlSymbolsParser(source));
    }
}
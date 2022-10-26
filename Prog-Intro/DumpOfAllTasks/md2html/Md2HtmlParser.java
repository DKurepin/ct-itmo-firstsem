package md2html;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Md2HtmlParser {
    static StringBuilder res;
    static int pos;
     static final Map<String, String> mdTags = new HashMap<>();

    static {
        mdTags.put("*", "em");
        mdTags.put("_", "em");
        mdTags.put("--", "s");
        mdTags.put("__", "strong");
        mdTags.put("**", "strong");
        mdTags.put("`", "code");
        mdTags.put("<", "&lt;");
        mdTags.put("&", "&amp;");
        mdTags.put(">", "&gt;");
        mdTags.put("%", "var");
    }

    public Md2HtmlParser(String str) {
        res = new StringBuilder();
        pos = 0;
        int headLevel = 0;
        int localLevel = 0;

        while (str.charAt(localLevel) == '#') {
            headLevel++;
            localLevel++;
        }
        if (str.charAt(localLevel) == ' ') {
            headLevel = localLevel;
        } else {
            headLevel = 0;
        }

        if (headLevel > 0) {
            res.append("<h").append(headLevel).append(">");
            pos = headLevel + 1;
            getText(res, str, "");
            res.append("</h").append(headLevel).append(">");
        } else {
            res.append("<p>");
            getText(res, str, "");
            res.append("</p>");
        }
    }


    public StringBuilder getText(StringBuilder res, String str, String tag) {
        StringBuilder result = null;
        String mdTag = "";
        String htmlTag = "";
        while (pos < str.length()) {
            char ch = str.charAt(pos);
            switch (ch) {
                case '*', '_':
                    if (ch != str.charAt(pos + 1)) {
                        mdTag = Character.toString(ch);
                        htmlTag = mdTags.get(mdTag);
                    } else {
                        mdTag = str.substring(pos, pos + 2);
                        htmlTag = mdTags.get(mdTag);
                        pos++;
                    }
                    break;
                case '-':
                    if (str.charAt(pos + 1) == ch) {
                        mdTag = str.substring(pos, pos + 2);
                        htmlTag = mdTags.get(mdTag);
                        pos++;
                    } else {
                        res.append(ch);
                    }
                    break;
                case '`', '%':
                    mdTag = Character.toString(ch);
                    htmlTag = mdTags.get(mdTag);
                    break;
                case '&', '>', '<':
                    res.append(mdTags.get(Character.toString(ch)));
                    break;
                case '\\':
                    pos++;
                    res.append(str.charAt(pos));
                    break;
                default:
                    res.append(ch);
                    break;
            }
            if (!mdTag.isEmpty())
                if (Objects.equals(tag, mdTag)) {
                    res.append("</").append(htmlTag).append(">");
                    result = res;
                    break;
                }
            pos++;
            if (!mdTag.isEmpty()) {
                StringBuilder newLine = getText(new StringBuilder(), str, mdTag);
                if (newLine.length() <= htmlTag.length()) {
                    res.append(mdTag).append(newLine);
                    if (Objects.equals(newLine.substring(newLine.length() - htmlTag.length() - 1,
                            newLine.length() - 1), htmlTag)) {
                        res.append("<").append(htmlTag).append(">").append(newLine);
                        pos++;
                    } else {
                        res.append(mdTag).append(newLine);
                    }
                } else {
                    if (Objects.equals(newLine.substring(newLine.length() - htmlTag.length() - 1,
                            newLine.length() - 1), htmlTag)) {
                        res.append("<").append(htmlTag).append(">").append(newLine);
                        pos++;
                    } else {
                        res.append(mdTag).append(newLine);
                    }
                }
                mdTag = "";
            }
        }
        if (result == null) {
            result = res;
        }
        return result;
    }
}
package markup;

import java.util.List;

public class Head implements MarkupInterface {
    List<MarkupInterface> text;
    private int headLevel;

    public Head(List<MarkupInterface> text, int headLevel) {
        this.text = text;
        this.headLevel = headLevel;
    }

    public void toMarkdown(StringBuilder string) {
        for (MarkupInterface i : this.text) {
            i.toMarkdown(string);
        }
    }

    @Override
    public void toBBCode(StringBuilder string) {
    }

    public void toHtml(StringBuilder string) {
        string.append("<h").append(headLevel).append(">");
        for (MarkupInterface i : this.text) {
            i.toHtml(string);
        }
        string.append("</h").append(headLevel).append(">");
    }
}

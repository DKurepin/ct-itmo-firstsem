package markup;

import java.util.List;

public abstract class Abstract implements MarkupInterface {
    protected List<MarkupInterface> text;

    public Abstract(List<MarkupInterface> list) {
        text = list;
    }

    @Override
    public void toMarkdown(StringBuilder string) {
        string.append(markSymbol());
        for (MarkupInterface i : text) {
            i.toMarkdown(string);
        }
        string.append(markSymbol());
    }

    protected abstract String markSymbol();

    public void toHtml(StringBuilder string) {
        string.append("<").append(htmlSymbol()).append(">");
        for (MarkupInterface i : text) {
            i.toHtml(string);
        }
        string.append("</").append(htmlSymbol()).append(">");
    }

    protected abstract String htmlSymbol();

    @Override
    public void toBBCode(StringBuilder string) {
        string.append("[").append(symbolBBCode()).append("]");
        for (MarkupInterface i : text) {
            i.toBBCode(string);
        }
        string.append("[/").append(symbolBBCode()).append("]");
    }

    protected abstract String symbolBBCode();
}

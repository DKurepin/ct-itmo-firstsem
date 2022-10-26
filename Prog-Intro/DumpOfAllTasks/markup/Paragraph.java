package markup;

import java.util.List;

public class Paragraph implements MarkupInterface {
    private final List<MarkupInterface> elements;

    public Paragraph(List<MarkupInterface> list) {
        elements = list;
    }

    @Override
    public void toMarkdown(StringBuilder string) {
        for (MarkupInterface i : elements) {
            i.toMarkdown(string);
        }
    }

    @Override
    public void toBBCode(StringBuilder string) {
        for (MarkupInterface i : elements) {
            i.toBBCode(string);
        }
    }

    @Override
    public void toHtml(StringBuilder string) {
        for (MarkupInterface i : elements) {
            i.toHtml(string);
        }
    }
}

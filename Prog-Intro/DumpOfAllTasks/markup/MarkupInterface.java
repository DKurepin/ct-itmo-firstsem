package markup;

public interface MarkupInterface {
    void toMarkdown(StringBuilder string);

    void toBBCode(StringBuilder string);

    void toHtml(StringBuilder string);
}



package markup;

public class Text implements MarkupInterface {
    private final String text;

    public Text(String str) { text = str; }

    @Override
    public void toMarkdown(StringBuilder string) {
        string.append(text);
    }

    @Override
    public void toBBCode(StringBuilder string) {
        string.append(text);
    }
}

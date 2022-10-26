package markup;

import java.util.List;

public class Strikeout extends Abstract {
    public Strikeout(List<MarkupInterface> list) { super(list); }

    @Override
    protected String symbolBBCode() {
        return "s";
    }

    @Override
    protected String markSymbol() {
        return "~";
    }
}

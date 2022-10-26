package markup;

import java.util.List;

public class Emphasis extends Abstract {
    public Emphasis(List<MarkupInterface> list) {
        super(list);
    }

    @Override
    protected String markSymbol() {
        return "*";
    }

    @Override
    protected String symbolBBCode() {
        return "i";
    }
}

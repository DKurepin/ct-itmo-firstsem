package markup;

import java.util.List;

public class Mark extends Abstract {
    public Mark(List<MarkupInterface> list) { super(list); }

    @Override
    protected String markSymbol() {
        return "~";
    }

    @Override
    protected String htmlSymbol() { return "mark"; }

    @Override
    protected String symbolBBCode() { return null; }
}

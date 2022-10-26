package markup;

import java.util.List;

public class Code extends Abstract{
    public Code(List<MarkupInterface> list) { super(list); }

    @Override
    protected String markSymbol() { return "'"; }

    @Override
    protected String htmlSymbol() { return "code"; }

    @Override
    protected String symbolBBCode() { return null; }
}

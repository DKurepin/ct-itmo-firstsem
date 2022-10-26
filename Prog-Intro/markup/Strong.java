package markup;

import java.util.List;

public class Strong extends Abstract {
    public Strong(List<MarkupInterface> list) { super(list); }


    @Override
    protected String symbolBBCode() {
        return "b";
    }


    @Override
    protected String markSymbol() {
        return "__";
    }
}

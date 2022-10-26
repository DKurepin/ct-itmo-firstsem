package expressions;

public class Substract extends AbstractOper {

    public Substract(MiniExpression first, MiniExpression second) { super(first, second); }

    @Override
    protected int count(int x, int y) { return x - y;}

    @Override
    protected char getType() { return '-';}

    @Override
    public int getPriority() {
        return 2;
    }
}


package expressions;

public class Multiply extends AbstractOper {

    public Multiply(MiniExpression first, MiniExpression second) { super(first, second); }

    @Override
    protected int count(int x, int y) { return x * y;}

    @Override
    protected char getType() { return '*';}

    @Override
    public int getPriority() {
        return 0;
    }
}

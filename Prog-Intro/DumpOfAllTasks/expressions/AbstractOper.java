package expressions;

import java.util.Objects;

public abstract class AbstractOper implements MiniExpression {
    private final MiniExpression first;
    private final MiniExpression second;

    public AbstractOper(MiniExpression first, MiniExpression second) {
        this.first = first;
        this.second = second;
    }

    protected abstract int count(int x, int y);

    protected abstract char getType();

    @Override
    public int evaluate(int x) { return count(first.evaluate(x), second.evaluate(x)); }

    public String toString() {
        return "(" + first + ' ' + getType() + ' ' + second + ")";
    }

    public String toMiniString() {
        StringBuilder str = new StringBuilder();
        if (first.getPriority() != 4 && getPriority() != 1 && getPriority() != 2 &&
                (getPriority() != 0 || (first.getPriority() != 0 && first.getPriority() != 3)) &&
                (getPriority() != 3 || (first.getPriority() != 0 && first.getPriority() != 3))) {
            str.append("(").append(first.toMiniString()).append(")");
        } else {
            str.append(first.toMiniString());
        }
        str.append(" ").append(getType()).append(" ");
        if (second.getPriority() != 4 && getPriority() != 1 &&
                (getPriority() != 2 || (second.getPriority() == 1 || second.getPriority() == 2)) &&
                (getPriority() != 0 || second.getPriority() != 0)) {
            str.append("(").append(second.toMiniString()).append(")");
        } else {
            str.append(second.toMiniString());
        }
        return str.toString();
    }

    @Override
    public boolean equals(Objects obj) {
        
    }



}

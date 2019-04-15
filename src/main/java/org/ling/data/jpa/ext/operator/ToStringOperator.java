package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import org.ling.data.jpa.ext.Operator;

import java.util.List;

public class ToStringOperator<T> extends AbstractOperator<T> implements ExpressionOperator<T> {
    public ToStringOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public ExpressionHolder toExpressionHolder() {

        ExpressionHolder<Character> x = ((ExpressionOperator<T>) children.get(0)).toExpressionHolder();

        return new ToStringExpressionHolder(x);
    }
}
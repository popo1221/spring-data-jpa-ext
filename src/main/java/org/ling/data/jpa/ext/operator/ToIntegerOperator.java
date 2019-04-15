package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import org.ling.data.jpa.ext.Operator;

import java.util.List;

public class ToIntegerOperator<T> extends AbstractOperator<T> implements ExpressionOperator<T> {
    public ToIntegerOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public ExpressionHolder toExpressionHolder() {

        ExpressionHolder<? extends Number> x = ((ExpressionOperator<T>)children.get(0)).toExpressionHolder();

        return new ToIntegerExpressionHolder(x);
    }
}
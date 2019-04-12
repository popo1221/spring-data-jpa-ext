package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import org.ling.data.jpa.ext.Operator;

import java.util.List;

public class UpperOperator<T> extends AbstractOperator<T> implements ExpressionOperator<T> {
    public UpperOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public ExpressionHolder<?> toExpressionHolder() {

        ExpressionHolder<String> x = ((ExpressionOperator<T>)children.get(0)).toExpressionHolder();

        return new UpperExpressionHolder(x);
    }
}

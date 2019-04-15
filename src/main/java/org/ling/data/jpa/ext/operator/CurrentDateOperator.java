package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import org.ling.data.jpa.ext.Operator;

import java.util.List;

public class CurrentDateOperator<T> extends AbstractOperator<T> implements ExpressionOperator<T> {
    public CurrentDateOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public ExpressionHolder<?> toExpressionHolder() {
        return new CurrentDateExpressionHolder();
    }
}

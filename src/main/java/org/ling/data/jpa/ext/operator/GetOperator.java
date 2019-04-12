package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import org.ling.data.jpa.ext.Operator;

import java.util.List;

public class GetOperator<T> extends AbstractOperator<T> implements ExpressionOperator<T> {

    public GetOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public <Y> ExpressionHolder<Y> toExpressionHolder() {
        return new GetExpressionHolder<>((String) value);
    }
}

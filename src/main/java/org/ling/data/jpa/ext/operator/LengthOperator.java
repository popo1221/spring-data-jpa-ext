package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import org.ling.data.jpa.ext.Operator;

import java.util.List;

public class LengthOperator<T> extends AbstractOperator<T> implements ExpressionOperator<T> {
    public LengthOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    @Override
    public ExpressionHolder<?> toExpressionHolder() {

        ExpressionHolder<String> x = ((ExpressionOperator<T>)children.get(0)).toExpressionHolder();

        return new LengthExpressionHolder(x);
    }
}

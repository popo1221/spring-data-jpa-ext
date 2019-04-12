package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.Operator;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class AbstractOperator<T> implements Operator<T> {

    protected final Object value;

    protected final List<Operator<T>> children;

    protected <Y> Y getObjectOrExpression(Operator operator) {
        if (operator instanceof ConstOperator) {
            return (Y) ((ConstOperator) operator).toObject();
        }

        if (operator instanceof ExpressionOperator) {
            return (Y) ((ExpressionOperator) operator).toExpressionHolder();
        }

        return null;
    }
}

package org.ling.data.jpa.ext.operator;

import org.ling.data.jpa.ext.ExpressionHolder;
import org.ling.data.jpa.ext.Operator;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SizeOperator<T> extends AbstractOperator<T> implements ExpressionOperator<T> {
    public SizeOperator(Object value, List<Operator<T>> children) {
        super(value, children);
    }

    ExpressionHolder<? extends Collection<?>> toExpressionHolder(ExpressionOperator<? extends Collection<?>> y) {
        return y.toExpressionHolder();
    }

    Collection<?> toCollection(ConstOperator x) {
        return (Collection<?>) x.toObject();
    }

    @Override
    public ExpressionHolder<Integer> toExpressionHolder() {
        Operator<?> x = children.get(0);

        if (x instanceof ExpressionOperator) {
            return SizeExpressionHolder.create(toExpressionHolder((ExpressionOperator<Collection<?>>) x));
        } {
            return SizeExpressionHolder.create(toCollection((ConstOperator) x));
        }
    }
}